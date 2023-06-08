package com.set.service.user;

import com.set.model.user.dao.UserDAO;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import static com.common.Template.getSqlSession;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/register")
public class UserRegister extends HttpServlet {

    private UserDAO userDAO;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        Map<String, String> userInfo = new HashMap<>();

        userInfo.put("userId", request.getParameter("userId"));
        userInfo.put("userPasswd", request.getParameter("userPasswd"));

        if(request.getParameter("userId") == ""){
            writer.write("<script>alert('아이디를 입력해주세요.');history.go(-1)</script>");
            writer.close();
        } else {
            if(request.getParameter("userPasswd") == ""){
                writer.write("<script>alert('비밀번호를 입력해주세요.');history.go(-1)</script>");
                writer.close();
            }
            SqlSession sqlSession = getSqlSession();
            userDAO = sqlSession.getMapper(UserDAO.class);

            int result = 0;

            try{
                result = userDAO.insertUser(userInfo);
            } catch (PersistenceException e) {
                sqlSession.rollback();
                sqlSession.close();
                writer.write("<script>alert('중복인 아이디가 존재합니다.');history.go(-1)</script>");
                writer.close();
            }

            if(result > 0){
                sqlSession.commit();
                sqlSession.close();
                writer.write("<script>alert('별과 심연을 향해! 원신 세팅 가이드에 온 걸 환영해.');location.href='/';</script>");
                writer.close();
            } else {
                sqlSession.rollback();
                sqlSession.close();
                writer.write("<script>alert('에러가 발생하였습니다. 다시 시도해주세요.');history.go(-1)</script>");
                writer.close();
            }
        }
    }
}
