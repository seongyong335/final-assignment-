package com.set.service.spec;

import com.set.model.character.dto.CharacterDTO;
import com.set.model.spec.dao.ExSpecDAO;
import com.set.model.spec.dao.SpecDAO;
import com.set.model.spec.dto.ExSpecDTO;
import com.set.model.spec.dto.SpecDTO;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.common.Template.getSqlSession;

@WebServlet("/jsp/spec/select")
public class SpecSelect extends HttpServlet {

    private SpecDAO specDAO;
    private ExSpecDAO exSpecDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        SqlSession sqlSession = getSqlSession();
        specDAO = sqlSession.getMapper(SpecDAO.class);
        exSpecDAO = sqlSession.getMapper(ExSpecDAO.class);

        SpecDTO specDTO = new SpecDTO();

        if(request.getParameter("userId") == null && request.getParameter("userId") == ""){
            writer.write("<script>alert('에러가 발생하여 다시 로그인 화면으로 돌아갑니다.');location.href='/';</script>");
            writer.close();
        }
        specDTO.setUserId(request.getParameter("userId"));

        if(request.getParameter("charNo") == null && request.getParameter("charNo") == ""){
            writer.write("<script>alert('에러가 발생하여 다시 로그인 화면으로 돌아갑니다.');location.href='/';</script>");
            writer.close();
        }
        specDTO.setCharNo(Integer.parseInt((String)request.getParameter("charNo")));

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

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        SqlSession sqlSession = getSqlSession();
        specDAO = sqlSession.getMapper(SpecDAO.class);
        exSpecDAO = sqlSession.getMapper(ExSpecDAO.class);

        SpecDTO specDTO = new SpecDTO();

        if(request.getParameter("userId") == null && request.getParameter("userId") == ""){
            writer.write("<script>alert('에러가 발생하여 다시 로그인 화면으로 돌아갑니다.');location.href='/';</script>");
            writer.close();
        } else {
            specDTO.setUserId(request.getParameter("userId"));
        }

        if(request.getParameter("charNo") == null && request.getParameter("charNo") == ""){
            writer.write("<script>alert('에러가 발생하여 다시 로그인 화면으로 돌아갑니다.');location.href='/';</script>");
            writer.close();
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

        }
    }
}
