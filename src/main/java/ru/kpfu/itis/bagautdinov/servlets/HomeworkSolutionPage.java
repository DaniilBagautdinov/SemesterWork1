package ru.kpfu.itis.bagautdinov.servlets;

import ru.kpfu.itis.bagautdinov.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeworkSolutionPageServlet", urlPatterns = "/homeworksolutionpage")
public class HomeworkSolutionPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        List<Homework> homeworks = (List<Homework>) session.getAttribute("homeworks");

        for (Homework homework : homeworks) {
            if(homework.getId() == id) {
                session.setAttribute("homeworkNow", homework);
            }
        }

        req.getServletContext().getRequestDispatcher("/homeworksolutionpage.ftl").forward(req, resp);
    }
}
