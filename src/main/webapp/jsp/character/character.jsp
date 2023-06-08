<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <button type="button" onclick="history.back()">Exit</button>
    </div>
    <div style="width:600px;">
        <c:forEach var="character" items="${ requestScope.characterList }" varStatus="st">
            <div style="width:74px; height:90px; float:left;">
                <a type="submit" href="/jsp/spec/input.jsp?charNo=${character.charNo}&charName=${character.charName}&charStar=${character.charStar}&charElement=${character.charElement}&userId=<%=request.getParameter("userId")%>">
                    <img height="70px" width="70px" src="/pic/character/${character.charName}.png"/> <br>
                    <img height="16px" width="16px" src="/pic/star/star-${character.charStar}.png"/>
                    <img height="16px" width="16px" src="/pic/element/Element_${character.charElement}.png" style="float: right"/>
                </a>
            </div>
        </c:forEach>
    </div>
</body>
</html>
