package com.set.service.character;

import com.set.model.character.dao.CharacterDAO;
import com.set.model.character.dto.CharacterDTO;
import com.set.view.character.CharacterPrint;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.common.Template.getSqlSession;

@WebServlet("/character/list")
public class CharacterList extends HttpServlet {
    private CharacterDAO characterDAO;
    private CharacterPrint characterPrint = new CharacterPrint();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        SqlSession sqlSession = getSqlSession();
        characterDAO = sqlSession.getMapper(CharacterDAO.class);

        List<CharacterDTO> list = characterDAO.selectCharacterList();

        request.setAttribute("characterList", list);
        request.setAttribute("userId", request.getAttribute("userId"));
        sqlSession.close();

        if(list != null && list.size() > 0){
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/character/character.jsp");
            rd.forward(request, response);
        } else {
            characterPrint.printErrorMessage("select");
        }
    }
}
