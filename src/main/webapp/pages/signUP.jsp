<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 10/25/2015
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <form action="SignUpServlet" method="post">
        <input type="text" name="name">Ім'я<Br>
        <input type="text" name="surname">Прізвище<Br>
        <input type="text" name="login">Логін<Br>
        <input type="text" name="password">Пароль<Br>
        <input type="text" name="confirmPassword">Підтвердити пароль<Br>
        <input type="submit" name="submit">
    </form>

</body>
</html>
