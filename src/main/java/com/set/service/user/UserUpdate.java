package com.set.service.user;

import com.set.model.user.dao.UserDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.common.Template.getSqlSession;

@WebServlet("/user/update")
public class UserUpdate extends HttpServlet {
    private UserDAO userDAO;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        Map<String, String> userInfo = new HashMap<>();

        userInfo.put("userId", request.getParameter("userId"));
        userInfo.put("userPasswd", request.getParameter("userPasswd"));

            if(request.getParameter("userPasswd") == ""){
                writer.write("<script>alert('비밀번호를 입력해주세요.');history.go(-1)</script>");
                writer.close();
            }
            SqlSession sqlSession = getSqlSession();
            userDAO = sqlSession.getMapper(UserDAO.class);

            int result = 0;

            try{
                result = userDAO.updateUser(userInfo);
            } catch (PersistenceException e) {
                sqlSession.rollback();
                sqlSession.close();
                writer.write("<script>alert('비밀번호를 제대로 입력해주세요.');history.go(-1)</script>");
                writer.close();
            }

            if(result > 0){
                sqlSession.commit();
                sqlSession.close();
                writer.write("<script>alert('수정완료!');location.href='/';</script>");
                writer.close();
            } else {
                sqlSession.rollback();
                sqlSession.close();
                writer.write("<script>alert('에러가 발생하였습니다. 다시 시도해주세요.');history.go(-1)</script>");
                writer.close();
            }
        }
    }
