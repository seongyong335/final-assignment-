package com.set.service.user;

import com.set.model.user.dao.UserDAO;
import com.set.view.user.UserPrint;
import org.apache.ibatis.session.SqlSession;
import static com.common.Template.getSqlSession;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/jsp/login/user/register")
public class UserRegister extends HttpServlet {

    private UserDAO userDAO;
    private UserPrint userPrint = new UserPrint();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userId = request.getParameter("userId");
//        String userPassword = request.getParameter("userPasswd");

        Map<String, String> userInfo = new HashMap<>();

        userInfo.put("userId", request.getParameter("userId"));
        userInfo.put("userPasswd", request.getParameter("userPasswd"));

        SqlSession sqlSession = getSqlSession();
        userDAO = sqlSession.getMapper(UserDAO.class);

        int result = userDAO.insertUser(userInfo);

        if(result > 0){
            sqlSession.commit();
            sqlSession.close();
            userPrint.printSuccessMessage("register");
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/login/login.jsp");
            rd.forward(request, response);
        } else {
            sqlSession.rollback();
            sqlSession.close();
            userPrint.printErrorMessage("register");
        }
    }
}
