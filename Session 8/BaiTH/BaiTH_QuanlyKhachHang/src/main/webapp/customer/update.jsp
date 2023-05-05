<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 26/04/2023
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer</title>
</head>
<body>
<p>
    <c:if test="${message != null}">
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="customers">Back to customer list</a>
</p>
<c:if test="${updateCustomer != null}">
    <table border="1">
        <tr>
            <td>Customer ID:</td>
            <td>${updateCustomer.id}</td>
        </tr>
        <tr>
            <td>Customer Name:</td>
            <td>${updateCustomer.name}</td>
        </tr>
        <tr>
            <td>Customer Email:</td>
            <td>${updateCustomer.email}</td>
        </tr>
        <tr>
            <td>Customer Address:</td>
            <td>${updateCustomer.address}</td>
        </tr>
    </table>
    <form method="post">
        <fieldset>
            <legend>Update Information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email"></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" id="address"></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="id" value="${updateCustomer.id}"></td>
                    <td>
                        <input type="submit" value="Update Customer">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</c:if>
</body>
</html>
