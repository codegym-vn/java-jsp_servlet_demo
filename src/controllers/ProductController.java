package controllers;

import model.entities.Product;
import model.services.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", urlPatterns = {"/productController"})
public class ProductController extends HttpServlet {
    private ProductServiceImpl productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == "add") {

        } else if (action == "delete") {
            String id = request.getParameter("id");
            productService.delete(Integer.parseInt(id));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        if (action == "add") {

        } else if (action.equals("delete")) {
            String id = request.getParameter("id");
            productService.delete(Integer.parseInt(id));
        } else {
            List<Product> products = productService.getAll();
            request.setAttribute("products", products);
            dispatcher = getServletContext().getRequestDispatcher("/views/product/index.jsp");
            dispatcher.forward(request, response);
        }

    }
}
