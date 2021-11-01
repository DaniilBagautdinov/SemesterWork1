package ru.kpfu.itis.bagautdinov.servlets;

import ru.kpfu.itis.bagautdinov.model.Homework;
import ru.kpfu.itis.bagautdinov.model.Lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "lessonPageServlet", urlPatterns = "/lessonpage")
public class LessonPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        List<Lesson> lessons = (List<Lesson>) session.getAttribute("lessons");

        for (Lesson lesson : lessons) {
            if (lesson.getId() == id) {
                session.setAttribute("lessonNow", lesson);
            }
        }

        req.getServletContext().getRequestDispatcher("/lessonpage.ftl").forward(req, resp);
    }
}
