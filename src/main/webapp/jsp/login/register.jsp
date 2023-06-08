<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>GENSHIN-SET</title>
</head>
<body>
    <h1>Register</h1>
    <form action="/jsp/login/user/register" method="post">
        <label>ID : </label>
        <input type="text" name="userId">
        <br>
        <label>Password : </label>
        <input type="password" name="userPasswd">
        <br>
        <input type="submit" onclick="location.href='/jsp/login/login.jsp'"></input>
    </form>
</body>
</html>
