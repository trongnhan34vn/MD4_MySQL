<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 06/05/2023
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/exchange" method="post">
  <input type="number" name="number">
    <select name="currency" id="">
        <option value="vnd">vnd</option>
        <option value="usd">usd</option>
    </select>
  <input type="submit" value="Exchange">
</form>
<h1>Kết quả: ${result}</h1>
</body>
</html>
