package ru.kpfu.itis.bagautdinov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.bagautdinov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.bagautdinov.model.User;
import ru.kpfu.itis.bagautdinov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);

    private  final UserServiceImpl userService = new UserServiceImpl();
    private final UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registration.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userDao.get(login) == null) {
            userService.save(new User(firstName, lastName, login, password));
            resp.sendRedirect("login.html");
        } else {
            resp.sendRedirect("/reg");
        }
    }
}
