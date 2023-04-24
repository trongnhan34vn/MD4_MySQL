package com.example.bai4_simpledictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SimpleDictionary", value = "/translate")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,String> dictionary =new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String search = request.getParameter("txtSearch");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if(result != null) {
            writer.println("Word: " + search);
            writer.println("Result: " + result);
        } else {
            writer.println("Not Found");
        }
        writer.println("</html>");
    }

    public void destroy() {
    }
}