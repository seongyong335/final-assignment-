<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String userId = (String)request.getAttribute("userId");
    %>
    <h3><%= userId %><button type="button" onclick="location.href='/jsp/login/login.jsp'" >로그아웃</button></h3>
    <br>
    <form action="/character/list" method="post">
        <input type="hidden" name="userId" value="<%=userId%>">
        <button type="submit" >캐릭터 추가</button>
    </form>
    <div style="width:600px;">
        <c:forEach var="character" items="${ requestScope.userCharacterList }" varStatus="st">
            <div style="width:74px; height:90px; float:left;">
                <a type="submit" href="/jsp/spec/select?charNo=${character.charNo}&userId=<%=request.getParameter("userId")%>">
                    <img height="70px" width="70px" src="/pic/character/${character.charName}.png"/> <br>
                    <img height="16px" width="16px" src="/pic/star/star-${character.charStar}.png"/>
                    <img height="16px" width="16px" src="/pic/element/Element_${character.charElement}.png" style="float: right"/>
                </a>
            </div>
        </c:forEach>
    </div>

</body>
</html>
