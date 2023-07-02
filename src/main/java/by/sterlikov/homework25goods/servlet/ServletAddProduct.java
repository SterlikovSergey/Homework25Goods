package by.sterlikov.homework25goods.servlet;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;
import by.sterlikov.homework25goods.service.UserService;
import by.sterlikov.homework25goods.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(value = "/products")
public class ServletAddProduct extends HttpServlet {
    UserService userService;
    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getSession().getAttribute("login");
        var productId = req.getParameter("productId");
        var productName = req.getParameter("productName");
        var category = req.getParameter("category");


        List<Product> products = List.of(new Product(Integer.parseInt(productId),productName,Integer.parseInt(category)));
        UserListProduct userListProduct = new UserListProduct((String) login,products);
        userService.addUserListProduct(userListProduct);


        User user = new User((String) login);
        Product product = new Product(Integer.parseInt(productId),productName,Integer.parseInt(category));
        try {
            userService.addProduct(user,product);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("success.jsp").forward(req,resp);



    }
}
