package controller;

import model.User;
import service.IUserService;
import service.UserServiceIMPL;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/user-servlet")
public class UserServlet extends HttpServlet {
    IUserService userService = new UserServiceIMPL();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show":
                showListUser(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDel = Integer.parseInt(request.getParameter("id"));
        userService.remove(idDel);
        request.setAttribute("messageDel", "Delete Success!");
        request.getRequestDispatcher("view/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                updateUser(request, response);
                break;
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idU = Integer.parseInt(request.getParameter("id"));
        String nameU = request.getParameter("name");
        String emailU = request.getParameter("email");
        String countryU = request.getParameter("country");
        User uUser = new User(idU,nameU,emailU,countryU);
        userService.save(uUser);
        request.setAttribute("message", "Update Success!");
        request.getRequestDispatcher("view/update.jsp").forward(request, response);
    }

    private void showFormUpdate (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idU = Integer.parseInt(request.getParameter("id"));
        User uUser = userService.findById(idU);
        request.setAttribute("uUser",uUser);
        request.getRequestDispatcher("view/update.jsp").forward(request,response);
    }
    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", userService.findAll());
        request.getRequestDispatcher("view/Home.jsp").forward(request,response);
    }
    public void destroy() {
    }
}