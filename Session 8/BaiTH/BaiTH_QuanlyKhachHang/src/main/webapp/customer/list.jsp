<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 25/04/2023
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
  <a href="customers?action=create">Create New Customer</a>
</p>

<table border="1">
  <tr>
      <td>Name</td>
      <td>Email</td>
      <td>Address</td>
      <td colspan="2">Action</td>
  </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href="customers?action=edit&id=${customer.getId()}">Edit</a></td>
            <td><a href="customers?action=delete&id=${customer.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
