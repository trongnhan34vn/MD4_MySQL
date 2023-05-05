<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 05/05/2023
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>
        <c:if test="${messagedel != null}">
            ${messagedel}
        </c:if>
    </h1>
    <table border="1">
       <tr>
           <td>ID</td>
           <td>Name</td>
           <td>Email</td>
           <td>Country</td>
           <td>Action</td>
       </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td>
                    <a href="user-servlet?action=delete&id=${user.id}">Delete</a>
                    <a href="user-servlet?action=update&id=${user.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
