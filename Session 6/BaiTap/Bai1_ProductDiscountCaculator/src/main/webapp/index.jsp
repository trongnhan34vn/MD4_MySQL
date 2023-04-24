<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="calculate">
    <h1>Discount Calculator</h1>
    <p>Product Description: </p>
    <input type="text" name="description">
    <p>List Price: </p>
    <input type="text" name="price">
    <p>Discount Percent: </p>
    <input type="text" name="percent">
    <input style="margin-top: 10px; display: block" type="submit" name="submit" value="Calculator Submit">
</form>
</body>
</html>