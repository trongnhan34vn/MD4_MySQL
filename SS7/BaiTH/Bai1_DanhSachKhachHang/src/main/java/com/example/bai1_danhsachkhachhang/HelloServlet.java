package com.example.bai1_danhsachkhachhang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/index.jsp")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public HelloServlet() {
        super();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        class Customer {
            int id;
            String name;
            String birth;
            String address;
            String url;

            public Customer(int id, String name, String birth, String address, String url) {
                this.id = id;
                this.name = name;
                this.birth = birth;
                this.address = address;
                this.url = url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBirth() {
                return birth;
            }

            public void setBirth(String birth) {
                this.birth = birth;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
        List<Customer> listCustomers = new ArrayList<>();
        listCustomers.add(new Customer(1, "Mai Văn Hoàn", "1983-08-20","HN", "url"));
        listCustomers.add(new Customer(2, "Nguyễn Văn Nam", "1983-08-21","HN", "url"));
        listCustomers.add(new Customer(3, "Nguyễn Thái Hoà", "1983-08-22","HN", "url"));
        listCustomers.add(new Customer(4, "Trần Đăng Khoa", "1983-08-17","HN", "url"));
        listCustomers.add(new Customer(5, "Nguyễn Đình Thi", "1983-08-19","HN", "url"));
        request.setAttribute("listCustomers", listCustomers);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Users/nhan/Desktop/IT Project/Java Web/SS7/Bai1_DanhSachKhachHang/src/main/webapp/index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void destroy() {
    }
}