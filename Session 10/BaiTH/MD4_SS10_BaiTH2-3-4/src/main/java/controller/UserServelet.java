package controller;

import model.User;
import service.IUserService;
import service.UserServiceIMPL;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/user-servlet")
public class UserServelet extends HttpServlet {
    IUserService userService;
    @Override
    public void init() throws ServletException {
        userService = new UserServiceIMPL();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "permission":
                addUserPermission(request, response);
                break;
            case "test-use-tran":
                testWithoutTran(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateWithoutTransaction();
    }


    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = new User("chinhnd", "chinhnd@rikkei.academy", "vn");
        int [] permission = {1,2,4};
        userService.addUserTransaction(user, permission);
        request.setAttribute("listUser", userService.selectAllUser());
        request.getRequestDispatcher("view/list.jsp").forward(request, response);
    }

    private void listUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("view/list.jsp").forward(request, response);
    }

    public void destroy() {
    }
}