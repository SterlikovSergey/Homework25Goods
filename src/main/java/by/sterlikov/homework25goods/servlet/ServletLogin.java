package by.sterlikov.homework25goods.servlet;

import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.service.UserService;
import by.sterlikov.homework25goods.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/login")
public class ServletLogin extends HttpServlet {

    UserService userService;
    User newUser;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");

        if (login.isEmpty()) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } else {
            try {
                String existsLogin = userService.findUserByLogin(login).getName();
                System.out.println(existsLogin);
                if (existsLogin != null) {
                    int existsId = userService.findUserByLogin(login).getId();
                    req.getSession().setAttribute("name", req.getParameter("login"));
                    req.getSession().setAttribute("existsId", existsId);
                    req.getRequestDispatcher("addProducts.jsp").forward(req, resp);
                } else {
                    newUser = new User(login);
                    userService.addUser(newUser);
                    int newExistId = userService.findUserByLogin(login).getId();
                    req.getSession().setAttribute("name", req.getParameter("login"));
                    req.getSession().setAttribute("existsId", newExistId);
                    req.getRequestDispatcher("addProducts.jsp").forward(req, resp);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
