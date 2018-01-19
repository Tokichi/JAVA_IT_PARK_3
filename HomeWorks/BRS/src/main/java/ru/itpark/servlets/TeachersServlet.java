package ru.itpark.servlets;

import ru.itpark.models.Teacher;
import ru.itpark.repository.TeachersRepository;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeachersServlet extends HttpServlet {

    private TeachersRepository teachersRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.teachersRepository = (TeachersRepository)config.getServletContext().getAttribute("teachersRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("teachers", teachersRepository.findAll());
        req.getRequestDispatcher("/jsp/teachers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String patronymic = req.getParameter("patronymic");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        Teacher teacher = Teacher.builder()
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .login(login)
                .password(password)
                .email(email)
                .build();

        teachersRepository.save(teacher);
        resp.sendRedirect("/teachers");
    }
}