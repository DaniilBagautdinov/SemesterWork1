package ru.kpfu.itis.bagautdinov.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "homePageServlet", urlPatterns = "/homepage")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                session.setAttribute("user", cookie.getValue());
            }
        }

        req.getServletContext().getRequestDispatcher("/homepage.ftl").forward(req, resp);
    }

}