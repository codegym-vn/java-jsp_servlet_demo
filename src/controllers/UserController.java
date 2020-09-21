package controllers;

import model.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userController", urlPatterns = {"/userController"})
public class UserController extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("action");
        switch (ac) {
            case "login":
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                boolean isLogined = userService.login(userName, password);
                if (isLogined) {
                   try {
                       response.sendRedirect("productController");
                   }catch (Exception ex) {
                       System.out.println(ex);
                   }

                }
                break;
            default:
                response.sendRedirect("views/user/login.jsp");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("action");
        ac = ac == null ? "" : ac;
        switch (ac) {
            case "login":
                response.sendRedirect("views/user/login.jsp");
                break;
            default:
                response.sendRedirect("views/user/login.jsp");
                break;
        }
    }
}
