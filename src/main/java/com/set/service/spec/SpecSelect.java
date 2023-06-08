package com.set.service.spec;

import com.set.model.character.dto.CharacterDTO;
import com.set.model.spec.dao.ExSpecDAO;
import com.set.model.spec.dao.SpecDAO;
import com.set.model.spec.dto.ExSpecDTO;
import com.set.model.spec.dto.SpecDTO;
import com.set.view.spec.SpecPrint;
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

@WebServlet("/jsp/spec/select")
public class SpecSelect extends HttpServlet {

    private SpecDAO specDAO;
    private ExSpecDAO exSpecDAO;
    private SpecPrint specPrint = new SpecPrint();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        SqlSession sqlSession = getSqlSession();
        specDAO = sqlSession.getMapper(SpecDAO.class);
        exSpecDAO = sqlSession.getMapper(ExSpecDAO.class);

        SpecDTO specDTO = new SpecDTO();
        ExSpecDTO exSpecDTO = new ExSpecDTO();

        if(request.getParameter("userId") == null){
            System.out.println("userId");
            specDTO.setUserId("test");
        } else {
            specDTO.setUserId(request.getParameter("userId"));
        }

        if(request.getParameter("charNo") == null){
            System.out.println("charNo");
            specDTO.setCharNo(0);
        } else {
            specDTO.setCharNo(Integer.parseInt((String)request.getParameter("charNo")));
        }

        List<SpecDTO> spec = specDAO.selectSpec(specDTO);
        List<CharacterDTO> userCharacter = specDAO.selectUserCharacter(specDTO);
        List<ExSpecDTO> exSpec = exSpecDAO.selectExSpec(specDTO);
        System.out.println(exSpec);
        request.setAttribute("spec", spec);
        request.setAttribute("exSpec", exSpec);
        request.setAttribute("charInfo", userCharacter);
        sqlSession.close();

        if(spec != null && spec.size() > 0){
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/spec/select.jsp");
            rd.forward(request, response);
        } else {
            specPrint.printErrorMessage("select");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        SqlSession sqlSession = getSqlSession();
        specDAO = sqlSession.getMapper(SpecDAO.class);
        exSpecDAO = sqlSession.getMapper(ExSpecDAO.class);

        SpecDTO specDTO = new SpecDTO();
        ExSpecDTO exSpecDTO = new ExSpecDTO();

        if(request.getParameter("userId") == null){
            System.out.println("userId");
            specDTO.setUserId("test");
        } else {
            specDTO.setUserId(request.getParameter("userId"));
        }

        if(request.getParameter("charNo") == null){
            System.out.println("charNo");
            specDTO.setCharNo(0);
        } else {
            specDTO.setCharNo(Integer.parseInt((String)request.getParameter("charNo")));
        }

        List<SpecDTO> spec = specDAO.selectSpec(specDTO);
        List<CharacterDTO> userCharacter = specDAO.selectUserCharacter(specDTO);
        List<ExSpecDTO> exSpec = exSpecDAO.selectExSpec(specDTO);

        request.setAttribute("spec", spec);
        request.setAttribute("exSpec", exSpec);
        request.setAttribute("charInfo", userCharacter);
        sqlSession.close();
        if(spec != null && spec.size() > 0){
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/spec/select.jsp");
            rd.forward(request, response);
        } else {
            specPrint.printErrorMessage("select");
        }
    }
}
