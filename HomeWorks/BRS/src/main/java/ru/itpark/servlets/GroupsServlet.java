package ru.itpark.servlets;

import ru.itpark.models.Group;
import ru.itpark.repository.GroupsRepository;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GroupsServlet extends HttpServlet {

    private GroupsRepository groupsRepository;

        @Override
        public void init(ServletConfig config) throws ServletException {
            this.groupsRepository = (GroupsRepository)config.getServletContext().getAttribute("groupsRepository");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("groups", groupsRepository.findAll());
            req.getRequestDispatcher("/jsp/groups.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");

        Group group = Group.builder()
                .name(name)
                .build();

        groupsRepository.save(group);
        resp.sendRedirect("/groups");
    }
}