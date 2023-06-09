package com.set.service.user;

import com.set.model.spec.dao.SpecDAO;
import com.set.model.user.dao.UserDAO;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.common.Template.getSqlSession;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {
    private UserDAO userDAO;

    private SpecDAO specDAO;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        Map<String, String> userInfo = new HashMap<>();

        userInfo.put("userId", request.getParameter("userId"));
        userInfo.put("userPasswd", request.getParameter("userPasswd"));

        SqlSession sqlSession = getSqlSession();
        userDAO = sqlSession.getMapper(UserDAO.class);
        specDAO = sqlSession.getMapper(SpecDAO.class);

        int result_s = 0;
        int result = 0;
        result_s = specDAO.deleteSpec(userInfo);
        if (result_s > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        result = userDAO.deleteUser(userInfo);

        if (result > 0) {
            sqlSession.commit();
            sqlSession.close();
            writer.write("<script>alert('그동안 고마웠어 여행자');location.href='/';</script>");
            writer.close();
        } else {
            sqlSession.rollback();
            sqlSession.close();
            writer.write("<script>alert('에러가 발생하였습니다. 다시 시도해주세요.');history.go(-1)</script>");
            writer.close();
        }
    }
}