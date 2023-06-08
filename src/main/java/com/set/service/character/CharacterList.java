package com.set.service.character;

import com.set.model.character.dao.CharacterDAO;
import com.set.model.character.dto.CharacterDTO;

import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

import static com.common.Template.getSqlSession;

@WebServlet("/character/list")
public class CharacterList extends HttpServlet {
    private CharacterDAO characterDAO;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        }
    }
}
