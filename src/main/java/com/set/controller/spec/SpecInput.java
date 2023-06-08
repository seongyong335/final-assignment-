package com.set.controller.spec;

import com.set.model.character.dto.CharacterDTO;
import com.set.model.spec.dao.SpecDAO;
import com.set.model.spec.dto.SpecDTO;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.common.Template.getSqlSession;

@WebServlet("/jsp/spec/spec/input")
public class SpecInput extends HttpServlet {

    private SpecDAO specDAO;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        SqlSession sqlSession = getSqlSession();
        specDAO = sqlSession.getMapper(SpecDAO.class);

        SpecDTO specDTO = new SpecDTO();

        if(request.getParameter("userId") == null && request.getParameter("userId") == ""){
            writer.write("<script>alert('에러가 발생하여 다시 로그인 화면으로 돌아갑니다.');location.href='/';</script>");
            writer.close();
        } else {
            specDTO.setUserId(request.getParameter("userId"));
        }
        if(request.getParameter("specWeapon") == null){
            System.out.println("specWeapon null");
            specDTO.setSpecWeapon("");
        } else {
            specDTO.setSpecWeapon(request.getParameter("specWeapon"));
        }
        if(request.getParameter("specArtifactFlower") == null){
            System.out.println("specArtifactFlower null");
            specDTO.setSpecArtifactFlower("");
        } else {
            specDTO.setSpecArtifactFlower(request.getParameter("specArtifactFlower"));
        }
        if(request.getParameter("specArtifactPlume") == null){
            System.out.println("specArtifactPlume null");
            specDTO.setSpecArtifactPlume("");
        } else {
            specDTO.setSpecArtifactPlume(request.getParameter("specArtifactPlume"));
        }
        if(request.getParameter("specArtifactSands") == null){
            System.out.println("specArtifactSands null");
            specDTO.setSpecArtifactSands("");
        } else {
            specDTO.setSpecArtifactSands(request.getParameter("specArtifactSands"));
        }
        if(request.getParameter("specArtifactGoblet") == null){
            System.out.println("specArtifactGoblet null");
            specDTO.setSpecArtifactGoblet("");
        } else {
            specDTO.setSpecArtifactGoblet(request.getParameter("specArtifactGoblet"));
        }
        if(request.getParameter("specArtifactCirclet") == null){
            System.out.println("specArtifactCirclet null");
            specDTO.setSpecArtifactCirclet("");
        } else {
            specDTO.setSpecArtifactCirclet(request.getParameter("specArtifactCirclet"));
        }
        if(request.getParameter("specEtc") == null){
            System.out.println("specEtc null");
            specDTO.setSpecEtc("");
        } else {
            specDTO.setSpecEtc(request.getParameter("specEtc"));
        }
        if(request.getParameter("specEtc2") == null){
            System.out.println("specEtc2 null");
            specDTO.setSpecEtc2("");
        } else {
            specDTO.setSpecEtc2(request.getParameter("specEtc2"));
        }

        try {
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
        } catch (NumberFormatException e){
            writer.write("<script>alert('값을 제대로 입력해주세요.');history.go(-1);</script>");
            writer.close();
        }

        int result = 0;
        try{
            result = specDAO.inputSpec(specDTO);
        }catch (Exception e){
            writer.write("<script>alert('이미 해당 캐릭터가 존재합니다.');history.go(-2);</script>");
            writer.close();
        }


        List<CharacterDTO> userCharacterList = specDAO.selectUserCharacterList(request.getParameter("userId"));
        request.setAttribute("userCharacterList", userCharacterList);

        System.out.println("result :" + result);

        if(result > 0){
            sqlSession.commit();

            sqlSession.close();

            RequestDispatcher rd = request.getRequestDispatcher("/jsp/main/main.jsp");

            request.setAttribute("userId", request.getParameter("userId"));
            rd.forward(request, response);
        } else {
            sqlSession.rollback();
        }
    }
}
