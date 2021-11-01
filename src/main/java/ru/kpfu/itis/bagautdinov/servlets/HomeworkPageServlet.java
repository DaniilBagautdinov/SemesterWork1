package ru.kpfu.itis.bagautdinov.servlets;

import ru.kpfu.itis.bagautdinov.dao.impl.HomeworkDaoImpl;
import ru.kpfu.itis.bagautdinov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "homeworkPageServlet", urlPatterns = "/homeworkpage")
public class HomeworkPageServlet extends HttpServlet {

    private final HomeworkDaoImpl homeworkDao = new HomeworkDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        session.setAttribute("homeworks", homeworkDao.getHomeworks(user.getId()));

        req.getServletContext().getRequestDispatcher("/homeworkpage.ftl").forward(req, resp);
    }
}
