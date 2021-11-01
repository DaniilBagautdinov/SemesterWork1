package ru.kpfu.itis.bagautdinov.servlets;

import ru.kpfu.itis.bagautdinov.dao.impl.HomeworkDaoImpl;
import ru.kpfu.itis.bagautdinov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.bagautdinov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {

    private final UserDaoImpl userDao = new UserDaoImpl();
    private final HomeworkDaoImpl homeworkDao = new HomeworkDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registration.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (userDao.get(username) == null) {
            userDao.save(new User(firstName, lastName, username, password));
            homeworkDao.createHomeworks(userDao.get(username).getId());
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/reg");
        }
    }
}
