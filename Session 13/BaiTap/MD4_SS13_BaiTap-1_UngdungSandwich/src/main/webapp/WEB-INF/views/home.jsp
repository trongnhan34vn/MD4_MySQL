<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 08/05/2023
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="condiment" method="post">
    <div>
        <label for="lettuce">lettuce</label>
        <input type="checkbox" value="lettuce" id="lettuce" name="condiment">
    </div>
    <div>
        <label for="tomato">tomato</label>
        <input type="checkbox" value="tomato" id="tomato" name="condiment">
    </div>
    <div>
        <label for="mustard">mustard</label>
        <input type="checkbox" value="mustard" id="mustard" name="condiment">
    </div>
    <div>
        <label for="sprouts">sprouts</label>
        <input type="checkbox" value="sprouts" id="sprouts" name="condiment">
    </div>
    <input type="submit" value="save">
</form>
</body>
</html>
