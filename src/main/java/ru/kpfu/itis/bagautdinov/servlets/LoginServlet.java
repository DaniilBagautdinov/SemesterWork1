package ru.kpfu.itis.bagautdinov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.bagautdinov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.bagautdinov.dto.UserDTO;
import ru.kpfu.itis.bagautdinov.helper.PasswordHelper;
import ru.kpfu.itis.bagautdinov.model.User;
import ru.kpfu.itis.bagautdinov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");

        String password = req.getParameter("password");
        List<User> users = UserDaoImpl.userDao.getAll();
        boolean flag = true;
        for (User user : users) {
            if (user.getLogin().equals(login) && PasswordHelper.encrypt(password).equals(user.getPassword())) {
                System.out.println(user.getPassword());
                logger.info("User with username = {} logged in", login);
                HttpSession session = req.getSession();
                session.setAttribute("username", login);
                session.setMaxInactiveInterval(60 * 60);

                Cookie userCookie = new Cookie("username", login);
                userCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(userCookie);
                flag = false;
                resp.sendRedirect("Main.jsp");

            }
        }
        if(flag) {
            resp.sendRedirect("/login");
        }
    }
}
