package com.example.bai1_danhsachkhachhang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", value = "/Hello")
public class HelloServlet extends HttpServlet {
    public static List<Customer> listCustomers = new ArrayList<>();
    static {
        listCustomers.add(new Customer(1, "Mai Văn Hoàn", "1983-08-20","HN", "url"));
        listCustomers.add(new Customer(2, "Nguyễn Văn Nam", "1983-08-21","HN", "url"));
        listCustomers.add(new Customer(3, "Nguyễn Thái Hoà", "1983-08-22","HN", "url"));
        listCustomers.add(new Customer(4, "Trần Đăng Khoa", "1983-08-17","HN", "url"));
        listCustomers.add(new Customer(5, "Nguyễn Đình Thi", "1983-08-19","HN", "url"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("listCustomers", listCustomers);
//        RequestDispatcher dispatcher = request
//                .getRequestDispatcher("webapp/index.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}