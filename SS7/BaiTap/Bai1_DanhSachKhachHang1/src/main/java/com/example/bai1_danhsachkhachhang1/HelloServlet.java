package com.example.bai1_danhsachkhachhang1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Customer> listCustomers = new ArrayList<>();
        listCustomers.add(new Customer(1, "Mai Văn Hoàn", "1983-08-20","HN", "url"));
        listCustomers.add(new Customer(2, "Nguyễn Văn Nam", "1983-08-21","HN", "url"));
        listCustomers.add(new Customer(3, "Nguyễn Thái Hoà", "1983-08-22","HN", "url"));
        listCustomers.add(new Customer(4, "Trần Đăng Khoa", "1983-08-17","HN", "url"));
        listCustomers.add(new Customer(5, "Nguyễn Đình Thi", "1983-08-19","HN", "url"));
        request.setAttribute("listCustomer", listCustomers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}