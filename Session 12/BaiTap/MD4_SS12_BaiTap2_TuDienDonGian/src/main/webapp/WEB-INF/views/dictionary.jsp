<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 06/05/2023
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
  <input type="text" name="word">
  <input type="submit" value="find">
</form>
<h1>Kết quả: ${result}</h1>
</body>
</html>
