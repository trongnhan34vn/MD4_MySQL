package com.example.bai2_calculator;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int number1 = Integer.parseInt(request.getParameter("num1"));
        int number2 = Integer.parseInt(request.getParameter("num2"));
        float result = 0;
        String operate = request.getParameter("operator");
        switch (operate) {
            case "plus":
                result = number1 + number2;
                break;
            case "sub":
                result = number1 - number2;
                break;
            case "multi":
                result = number1 * number2;
                break;
            case "div":
                result = (float) number1 / number2;
                break;
        }
        Operator newOperator = new Operator(number1, number2, getOperator(operate), result);
        request.setAttribute("result", newOperator);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public String getOperator(String operator) {
        switch (operator) {
            case "plus":
                return "+";
            case "sub":
                return "-";
            case "multi":
                return "*";
            case "div":
                return "/";
        }
        return null;
    }

    public void destroy() {
    }
}