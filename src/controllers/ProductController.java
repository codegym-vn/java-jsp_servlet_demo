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
        if (action.equals("create")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            Product p = new Product(id,name,price,categoryId);
           boolean isAdded = productService.create(p);
           if(isAdded){
               response.sendRedirect("/productController");
           }
        } else if (action.equals("edit")) {

        } else if (action.equals("search")) {

        }
        RequestDispatcher dispatcher;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        if (action == "add") {

        } else if (action.equals("delete")) {
            String id = request.getParameter("id");
            boolean isDeleted = productService.delete(Integer.parseInt(id));
            if (isDeleted) {
                response.sendRedirect("productController");
            }
        } else if (action.equals("update")) {
            dispatcher = getServletContext().getRequestDispatcher("/views/product/update.jsp");
            dispatcher.forward(request, response);
        } else {
            List<Product> products = productService.getAll();
            request.setAttribute("products", products);
            dispatcher = getServletContext().getRequestDispatcher("/views/product/index.jsp");
            dispatcher.forward(request, response);
        }

    }
}
