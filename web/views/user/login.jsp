<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17/9/2020
  Time: 01:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="../../userController?action=login" method="post">
    Email : <input type="text" name="username"/> <br/>
    Password :<input type="text" name="password" /><br/>
    <input type="submit" value="Login" />
</form>
</body>
</html>
