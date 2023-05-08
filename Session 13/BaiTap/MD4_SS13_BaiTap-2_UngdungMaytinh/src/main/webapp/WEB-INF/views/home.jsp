<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 08/05/2023
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="calculator" method="post">
  <input type="number" name="num1">
  <select name="operator" id="">
    <option value="sum">sum(+)</option>
    <option value="subtract">subtract(-)</option>
    <option value="multiple">multiple(x)</option>
    <option value="divide">divide(/)</option>
  </select>
  <input type="number" name="num2">
  <input type="submit" value="Equal">
</form>
<h1>Result: <span style="color: red">${result}</span></h1>
</body>
</html>
