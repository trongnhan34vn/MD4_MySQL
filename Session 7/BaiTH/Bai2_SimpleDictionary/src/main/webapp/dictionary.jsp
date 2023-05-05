<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--

  Created by IntelliJ IDEA.
  User: nhan
  Date: 23/04/2023
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String, String> dictionary = new HashMap<>();
    dictionary.put("hello", "Xin chào");
    dictionary.put("how", "Thế nào");
    dictionary.put("book", "Quyển vở");
    dictionary.put("computer", "Máy tính");

    String search = request.getParameter("search");

    String result = dictionary.get(search);
    PrintWriter printWriter = response.getWriter();
    if (result != null) {
        printWriter.write("<h1> Vietnamese: " + search +"</h1>");
        printWriter.write("<h1> English: " + result + "</h1>");
    } else {
        printWriter.write("<h1>Not Found</h1>");
    }
%>
</body>
</html>
