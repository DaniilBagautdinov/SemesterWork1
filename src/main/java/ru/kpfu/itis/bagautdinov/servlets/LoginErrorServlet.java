package ru.kpfu.itis.bagautdinov.servlets;

import ru.kpfu.itis.bagautdinov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.bagautdinov.helper.PasswordHelper;
import ru.kpfu.itis.bagautdinov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "loginErrorServlet", urlPatterns = "/loginerror")
public class LoginErrorServlet extends HttpServlet {

    private final UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("loginerror.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("remember");
        HttpSession session = req.getSession();

        User user = userDao.get(username);

        if (username.equals("") || password.equals("")) {
            resp.sendRedirect("/loginerror");
        } else if (user != null && Objects.equals(PasswordHelper.encrypt(password), user.getPassword())) {

            if (cookieCheck != null && cookieCheck.equals("check")) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(100);
                resp.addCookie(cookie);
            }
            session.setAttribute("user",user);
            resp.sendRedirect("/homepage");

        } else {
            resp.sendRedirect("/loginerror");
        }
    }
}
