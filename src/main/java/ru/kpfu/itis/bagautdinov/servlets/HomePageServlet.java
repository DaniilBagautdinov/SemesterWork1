package ru.kpfu.itis.bagautdinov.servlets;

import ru.kpfu.itis.bagautdinov.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "homePageServlet", urlPatterns = "/homepage")
public class HomePageServlet extends HttpServlet {

    private final UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                session.setAttribute("user", userDao.get(cookie.getValue()));
            }
        }

        req.getServletContext().getRequestDispatcher("/homepage.ftl").forward(req, resp);
    }

}
