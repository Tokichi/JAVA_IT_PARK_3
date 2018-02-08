package ru.itpark.servlets;

import ru.itpark.models.Group;
import ru.itpark.repository.GroupsRepository;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudyGroupsServlet extends HttpServlet {

    private GroupsRepository studyGroupsRepository;

        @Override
        public void init(ServletConfig config) throws ServletException {
            this.studyGroupsRepository = (GroupsRepository)config.getServletContext().getAttribute("studyGroupsRepository");
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

        Group group = Group.builder()
                .name(name)
                .build();

        studyGroupsRepository.save(group);
        resp.sendRedirect("/studyGroups");
    }
}