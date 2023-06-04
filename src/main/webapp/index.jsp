<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>GENSHIN-SET</title>
</head>
<body>
    <h1>GENSHIN-SET</h1>
    <form action="user/logIn" method="post">
        <label>ID : </label>
        <input type="text" name="userId">
        <br>
        <label>Password : </label>
        <input type="password" name="userPasswd">
        <br>
        <button type="submit">Log-In</button>
        <br>
        <button type="button" onclick="location.href='jsp/register.jsp'">Register</button>
    </form>
</body>
</html>