package ru.kpfu.itis.bagautdinov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.bagautdinov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.bagautdinov.helper.PasswordHelper;
import ru.kpfu.itis.bagautdinov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    private final UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");

        String password = req.getParameter("password");
        User user = userDao.get(login);

        if (user != null && Objects.equals(PasswordHelper.encrypt(password), user.getPassword())) {
            System.out.println(user.getPassword());
            logger.info("User with username = {} logged in", login);
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
            session.setMaxInactiveInterval(60 * 60);

            Cookie userFirstNameCookie = new Cookie("firstName", user.getFirstName());
            Cookie userLastNameCookie = new Cookie("lastName", user.getLastName());
            Cookie userLoginCookie = new Cookie("login", user.getLogin());
            userFirstNameCookie.setMaxAge(24 * 60 * 60);
            userLastNameCookie.setMaxAge(24 * 60 * 60);
            userLoginCookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(userFirstNameCookie);
            resp.addCookie(userLoginCookie);
            resp.addCookie(userLastNameCookie);
            resp.sendRedirect("profile.jsp");

        } else {
            resp.sendRedirect("/login");
        }
    }
}
