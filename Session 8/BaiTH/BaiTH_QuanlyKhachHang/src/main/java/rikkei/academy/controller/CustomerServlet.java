package rikkei.academy.controller;

import rikkei.academy.model.Customer;
import rikkei.academy.service.CustomerServiceIMPL;
import rikkei.academy.service.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceIMPL();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                showFormDelete(request,response);
                break;
            case "view":
                break;
            default:
                listCustomers(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                break;
        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDel = Integer.parseInt(request.getParameter("id"));
        customerService.remove(idDel);
        request.setAttribute("message", "Delete Success!");
        request.getRequestDispatcher("/customer/delete.jsp").forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDel = Integer.parseInt(request.getParameter("id"));
        Customer delCustomer = customerService.findById(idDel);
        request.setAttribute("delCustomer", delCustomer);
        request.getRequestDispatcher("customer/delete.jsp").forward(request,response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newName = request.getParameter("name");
        String newEmail = request.getParameter("email");
        String newAddress = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer uCustomer = new Customer(id, newName, newEmail, newAddress);
        customerService.save(uCustomer);
        request.setAttribute("message", "Update Success!");
        request.getRequestDispatcher("customer/update.jsp").forward(request,response);
    }
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Customer> customerList = customerService.findAll();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id;
        if (customerList.isEmpty()) {
            id = 1;
        } else {
            id = customerList.get(customerList.size() - 1).getId() + 1;
        }
        Customer newCustomer = new Customer(id, name, email, address);
        customerService.save(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message", "New customer was created!");
        dispatcher.forward(request,response);
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idU = Integer.parseInt(request.getParameter("id"));
        Customer updateCustomer = customerService.findById(idU);
        request.setAttribute("updateCustomer", updateCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/update.jsp");
        dispatcher.forward(request,response);
    }
}
