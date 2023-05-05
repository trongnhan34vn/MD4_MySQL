<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 26/04/2023
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
<p>
    <a href="customers">Back to customer list</a>
</p>
<p>
    <c:if test="${message != null}">
        <span class="message">${message}</span>
    </c:if>
</p>
<c:if test="${delCustomer != null}">
    <table border="1">
        <tr>
            <td>Customer ID:</td>
            <td>${delCustomer.id}</td>
        </tr>
        <tr>
            <td>Customer Name:</td>
            <td>${delCustomer.name}</td>
        </tr>
        <tr>
            <td>Customer Email:</td>
            <td>${delCustomer.email}</td>
        </tr>
        <tr>
            <td>Customer Address:</td>
            <td>${delCustomer.address}</td>
        </tr>
    </table>
    <form method="post">
        <table>
            <tr>
                <td colspan="2">Do you want to delete this Customer?</td>
            </tr>
            <tr>
                <input type="hidden" value="${delCustomer.id}" name="id">
                <td><input type="submit" value="Yes"></td>
                <td><a style="text-decoration: none; color: black;" href="customers"><input type="button" value="No"></a></td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>
