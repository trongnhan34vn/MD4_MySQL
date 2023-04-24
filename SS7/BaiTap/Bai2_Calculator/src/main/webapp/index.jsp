<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="calculator" method="post">
    <h1>SIMPLE CALCULATOR</h1>
    <table>
        <tbody>
        <tr>
            <td>First operand: </td>
            <td><input type="number" name="num1"></td>
        </tr>
        <tr>
            <td>Operator: </td>
            <td>
                <select name="operator">
                    <option value="plus">Addition</option>
                    <option value="sub">Subtraction</option>
                    <option value="multi">Multiplication</option>
                    <option value="div">Division</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Second operand: </td>
            <td><input type="number" name="num2"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Calculate">
            </td>
        </tr>
        </tbody>
    </table>

</form>
<c:if test="${result != null}">
    <h1>${result.num1} ${result.operator} ${result.num2} = ${result.result}</h1>
</c:if>

</body>
</html>