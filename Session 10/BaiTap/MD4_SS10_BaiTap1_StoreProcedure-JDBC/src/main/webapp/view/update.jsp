<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 05/05/2023
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h1 style="color: green">
    <c:if test="${message != null}">
        ${message}
        <a href="user-servlet?action=show">Back To Home</a>
    </c:if>
</h1>
<form method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" disabled name="id" value="${uUser.id}"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${uUser.name}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${uUser.email}"></td>
        </tr>
        <tr>
            <td>Country</td>
            <td><input type="text" name="country" value="${uUser.country}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
