package com.set.service.spec;

import com.set.model.character.dao.CharacterDAO;
import com.set.model.character.dto.CharacterDTO;
import com.set.model.spec.dao.SpecDAO;
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

@WebServlet("/jsp/spec/spec/input")
public class SpecInput extends HttpServlet {

    private SpecDAO specDAO;
    private SpecPrint specPrint = new SpecPrint();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        SqlSession sqlSession = getSqlSession();
        specDAO = sqlSession.getMapper(SpecDAO.class);

        SpecDTO specDTO = new SpecDTO();

        if(request.getParameter("userId") == null){
            System.out.println("userId");
            specDTO.setUserId("test");
        } else {
            specDTO.setUserId(request.getParameter("userId"));
        }
        if(request.getParameter("specWeapon") == null){
            System.out.println("specWeapon");
            specDTO.setSpecWeapon("specWeapon");
        } else {
            specDTO.setSpecWeapon(request.getParameter("specWeapon"));
        }
        if(request.getParameter("specArtifactFlower") == null){
            System.out.println("specArtifactFlower");
            specDTO.setSpecArtifactFlower("specArtifactFlower");
        } else {
            specDTO.setSpecArtifactFlower(request.getParameter("specArtifactFlower"));
        }
        if(request.getParameter("specArtifactPlume") == null){
            System.out.println("specArtifactPlume");
            specDTO.setSpecArtifactPlume("specArtifactPlume");
        } else {
            specDTO.setSpecArtifactPlume(request.getParameter("specArtifactPlume"));
        }
        if(request.getParameter("specArtifactSands") == null){
            System.out.println("specArtifactSands");
            specDTO.setSpecArtifactSands("specArtifactSands");
        } else {
            specDTO.setSpecArtifactSands(request.getParameter("specArtifactSands"));
        }
        if(request.getParameter("specArtifactGoblet") == null){
            System.out.println("specArtifactGoblet");
            specDTO.setSpecArtifactGoblet("specArtifactGoblet");
        } else {
            specDTO.setSpecArtifactGoblet(request.getParameter("specArtifactGoblet"));
        }
        if(request.getParameter("specArtifactCirclet") == null){
            System.out.println("specArtifactCirclet");
            specDTO.setSpecArtifactCirclet("specArtifactCirclet");
        } else {
            specDTO.setSpecArtifactCirclet(request.getParameter("specArtifactCirclet"));
        }
        if(request.getParameter("specEtc") == null){
            System.out.println("specEtc");
            specDTO.setSpecEtc("specEtc");
        } else {
            specDTO.setSpecEtc(request.getParameter("specEtc"));
        }
        if(request.getParameter("specEtc2") == null){
            System.out.println("specEtc2");
            specDTO.setSpecEtc("specEtc2");
        } else {
            specDTO.setSpecEtc2(request.getParameter("specEtc2"));
        }
        specDTO.setCharNo(Integer.parseInt(request.getParameter("charNo")));
        specDTO.setSpecSk1(Integer.parseInt(request.getParameter("specSk1")));
        specDTO.setSpecSk2(Integer.parseInt(request.getParameter("specSk2")));
        specDTO.setSpecSk3(Integer.parseInt(request.getParameter("specSk3")));
        specDTO.setSpecHp(Integer.parseInt(request.getParameter("specHp")));
        specDTO.setSpecDef(Integer.parseInt(request.getParameter("specDef")));
        specDTO.setSpecAfk(Integer.parseInt(request.getParameter("specAfk")));
        specDTO.setSpecEm(Integer.parseInt(request.getParameter("specEm")));
        specDTO.setSpecEr(Double.parseDouble(request.getParameter("specEr")));
        specDTO.setSpecCr(Double.parseDouble(request.getParameter("specCr")));
        specDTO.setSpecCdmg(Double.parseDouble(request.getParameter("specCdmg")));

        int result = specDAO.inputSpec(specDTO);
        List<CharacterDTO> userCharacterList = specDAO.selectUserCharacterList(request.getParameter("userId"));
        request.setAttribute("userCharacterList", userCharacterList);

        System.out.println("result :" + result);

        if(result > 0){
            sqlSession.commit();
            specPrint.printSuccessMessage("input");
            sqlSession.close();

            RequestDispatcher rd = request.getRequestDispatcher("/jsp/main/main.jsp");

            request.setAttribute("userId", request.getParameter("userId"));
            rd.forward(request, response);
        } else {
            sqlSession.rollback();
            specPrint.printErrorMessage("input");
        }
    }
}
