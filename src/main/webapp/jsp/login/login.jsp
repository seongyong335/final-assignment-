<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>GENSHIN-SET</title>
</head>
<body>
    <h1>GENSHIN-SET</h1>
    <form action="/jsp/login/user/login" method="post">
        <label>ID : </label>
        <input type="text" name="userId">
        <br>
        <label>Password : </label>
        <input type="password" name="userPasswd">
        <br>
        <button type="submit">Log-In</button>
        <br>
        <button type="button" onclick="location.href='/jsp/login/register.jsp'">Register</button>

    </form>
</body>
</html>
