<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>

<table border="1">
    <tbody>
    <c:forEach items="${listCustomers}" var="customer">
        <tr>
            <td>${customer.name}</td>   // tên
            <td>${customer.birth}</td>   // ngày sinh
            <td>${customer.address}</td>   // address
            <td>${customer.url}</td>   // ảnh
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>