package ru.kpfu.itis.bagautdinov.servlets;

import ru.kpfu.itis.bagautdinov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.bagautdinov.helper.PasswordHelper;
import ru.kpfu.itis.bagautdinov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "editPageServlet", urlPatterns = "/editpage")
public class EditPageServlet extends HttpServlet {

    private final UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/editpage.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (!firstName.equals("")) {
            userDao.changeFirstName(user.getId(), firstName);
        }
        if (!lastName.equals("")) {
            userDao.changeLastName(user.getId(), lastName);
        }
        if (!password.equals("")) {
            userDao.changePassword(user.getId(), PasswordHelper.encrypt(password));
        }

        User newUser = userDao.get(user.getUsername());
        session.setAttribute("user", newUser);

        resp.sendRedirect("profilepage.ftl");
    }
}
