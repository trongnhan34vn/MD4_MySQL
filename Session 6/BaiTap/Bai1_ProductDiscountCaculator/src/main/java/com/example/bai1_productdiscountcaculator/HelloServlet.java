package com.example.bai1_productdiscountcaculator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", value = "/calculate")
public class HelloServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float percent = Float.parseFloat(request.getParameter("percent"));
        float result = price * percent;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Description: " + description);
        writer.println("Price: " + price);
        writer.println("Percent: " + percent);
        writer.println("Result: " + result);
        writer.println("</html>");
    }

    public void destroy() {
    }
}