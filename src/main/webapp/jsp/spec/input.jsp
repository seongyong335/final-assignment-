<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int charNo = Integer.parseInt(request.getParameter("charNo"));
        String charName = request.getParameter("charName");
        String charElement = request.getParameter("charElement");
        int charStar = Integer.parseInt(request.getParameter("charStar"));
        String userId = request.getParameter("userId");
    %>
    <form action="spec/input" method="post">
        <datalist id="ArtifactSands">
            <option value="공격력(%)"/>
            <option value="방어력(%)"/>
            <option value="체력(%)"/>
            <option value="원소 마스터리"/>
            <option value="원소 충전효율(%)"/>
        </datalist>
        <datalist id="ArtifactGoblet">
            <option value="공격력(%)"/>
            <option value="방어력(%)"/>
            <option value="체력(%)"/>
            <option value="원소 마스터리"/>
            <option value="원소 피해(%)"/>
        </datalist>
        <datalist id="ArtifactCirclet">
            <option value="공격력(%)"/>
            <option value="방어력(%)"/>
            <option value="체력(%)"/>
            <option value="원소 마스터리"/>
            <option value="치명타 확률(%)"/>
            <option value="치명타 피해량(%)"/>
        </datalist>
        <div style="width:140px; float: left">
            <img height="140px" width="140px" src="/pic/character/<%= charName %>.png"/>
            <img height="32px" width="32px" src="/pic/star/star-<%= charStar %>.png"/>
            <img height="32px" width="32px" src="/pic/element/Element_<%= charElement %>.png" style="float: right;"/>
        </div>
        <div id="specStatus" style="width:300px; float: left;">
            <label>체력</label><input type="text" name="specHp"><br>
            <label>방어력</label><input type="text" name="specDef"><br>
            <label>공격력</label><input type="text" name="specAfk"><br>
            <label>원소마스터리</label><input type="text" name="specEm"><br>
            <label>원소충전</label><input type="text" name="specEr"><br>
            <label>치명타-확률</label><input type="text" name="specCr"><br>
            <label>치명타-피해</label><input type="text" name="specCdmg"><br>
            <label>기본공격</label><input type="number" name="specSk1" min="1" max="13"><br>
            <label>원소스킬</label><input type="number" name="specSk2" min="1" max="13"><br>
            <label>원소폭발</label><input type="number" name="specSk3" min="1" max="13"><br>
        </div>
        <div id="specArtifacts" style="width:300px; float: left;">
            <label>무기</label><input type="text" name="specWeapon"><br>
            <label>성유물-꽃</label><input type="text" name="specArtifactFlower" value="체력" readonly><br>
            <label>성유물-깃털</label><input type="text" name="specArtifactPlume" value="공격력" readonly><br>
            <label>성유물-모래시계</label><input type="text" name="specArtifactSands" list="ArtifactSands"><br>
            <label>성유물-성배</label><input type="text" name="specArtifactGoblet" list="ArtifactGoblet"><br>
            <label>성유물-왕관</label><input type="text" name="specArtifactCirclet" list="ArtifactCirclet"><br>
            <label>기타</label><input type="text" name="specEtc"><br>
            <label>기타2</label><input type="text" name="specEtc2"><br>
        </div>
        <div>
            <input type="hidden" name="userId" value="<%=userId%>">
            <input type="hidden" name="charNo" value="<%=charNo%>">
            <button type="submit">Add</button>
            <button type="reset">Reset</button>
            <button type="button" onclick="history.back()">Exit</button>
        </div>
    </form>

</body>
</html>
