package controllers;

import entities.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "userController", urlPatterns = {"/userController"})
public class userController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ac = request.getParameter("action");
        RequestDispatcher dispatcher;
        ArrayList<Student> studentList;
        switch (ac) {
            case "login":
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                boolean isLogined = login(userName, password);
                if (isLogined) {
                    studentList = getAll();
                    request.setAttribute("studentList", studentList);
                    dispatcher = getServletContext().getRequestDispatcher("/views/employee/index.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            default:
                response.sendRedirect("views/user/login.jsp");
                break;
        }
    }

    protected ArrayList<Student> getAll() {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("R001", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new Student("R002", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new Student("R003", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new Student("R004", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new Student("R005", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        return studentList;
    }

    protected boolean login(String userName, String password) {
        boolean isLogined = false;
        if (userName.equals("admin") && password.equals("123123")) {
            isLogined = true;
        }
        return isLogined;
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
