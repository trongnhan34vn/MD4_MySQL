<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<c:if test="${listCustomer == null}">
    <c:redirect url="/hello"/>
</c:if>
<c:if test="${listCustomer != null}">

    <table border="1">
        <thead>
        <tr>
            <td>Tên</td>
            <td>Ngày sinh</td>
            <td>Địa chỉ</td>
            <td>Ảnh</td>
        </tr>
        </thead>
        <c:forEach items="${listCustomer}" var="customer">
            <tbody>
                <tr>
                    <td>${customer.name}</td>
                    <td>${customer.birth}</td>
                    <td>${customer.address}</td>
                    <td>${customer.url}</td>
                </tr>
            </tbody>
        </c:forEach>
    </table>
</c:if>
</body>
</html>