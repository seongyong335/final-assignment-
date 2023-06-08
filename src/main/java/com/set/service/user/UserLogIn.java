package com.set.service.user;

import com.set.model.character.dto.CharacterDTO;
import com.set.model.spec.dao.SpecDAO;
import com.set.model.user.dao.UserDAO;
import com.set.model.user.dto.UserDTO;

import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

@WebServlet("/user/login")
public class UserLogIn extends HttpServlet {

    private UserDAO userDAO;
    private SpecDAO specDAO;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        SqlSession sqlSession = getSqlSession();
        userDAO = sqlSession.getMapper(UserDAO.class);
        specDAO = sqlSession.getMapper(SpecDAO.class);

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
            List<UserDTO> list = userDAO.selectUser(userInfo);
            List<CharacterDTO> userCharacterList = specDAO.selectUserCharacterList(request.getParameter("userId"));

            sqlSession.close();

            if(list != null && list.size() > 0){
                request.setAttribute("userId", request.getParameter("userId"));
                request.setAttribute("userCharacterList", userCharacterList);

                RequestDispatcher rd = request.getRequestDispatcher("/jsp/main/main.jsp");
                rd.forward(request, response);
            } else {
                writer.write("<script>alert('아이디 혹은 비밀번호가 맞지 않습니다');history.go(-1)</script>");
                writer.close();
            }
        }
    }
}
