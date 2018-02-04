package ru.itpark.servlets;

import ru.itpark.models.StudyGroup;
import ru.itpark.repository.StudyGroupsRepository;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudyGroupsServlet extends HttpServlet {

    private StudyGroupsRepository studyGroupsRepository;

        @Override
        public void init(ServletConfig config) throws ServletException {
            this.studyGroupsRepository = (StudyGroupsRepository)config.getServletContext().getAttribute("studyGroupsRepository");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("studyGroups", studyGroupsRepository.findAll());
            req.getRequestDispatcher("/jsp/studyGroups.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");

        StudyGroup studyGroup = StudyGroup.builder()
                .name(name)
                .build();

        studyGroupsRepository.save(studyGroup);
        resp.sendRedirect("/studyGroups");
    }
}