package ru.itpark.servlets;

import ru.itpark.models.Student;
import ru.itpark.repository.StudentsRepository;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentsServlet extends HttpServlet {

    private StudentsRepository studentsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.studentsRepository = (StudentsRepository)config.getServletContext().getAttribute("studentsRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", studentsRepository.findAll());
        req.getRequestDispatcher("/jsp/students.jsp").forward(req, resp);
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

        Student student = Student.builder()
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .login(login)
                .password(password)
                .email(email)
                .build();

        studentsRepository.save(student);
        resp.sendRedirect("/students");
    }
}