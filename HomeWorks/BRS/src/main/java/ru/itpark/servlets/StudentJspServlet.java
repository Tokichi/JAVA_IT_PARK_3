package ru.itpark.servlets;

import ru.itpark.models.Student;
import ru.itpark.dao.StudentDao;
import ru.itpark.dao.StudentRepositoryEntityManagerImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentJspServlet extends HttpServlet {

    private StudentDao studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.studentRepository = (StudentDao)config.getServletContext().getAttribute("studentDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hello", "Список студентов");

        req.setAttribute("students", studentRepository.findAll());
        req.getRequestDispatcher("/jsp/students_with_tags.jsp").forward(req, resp);
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

        Student students = Student.builder()
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .login(login)
                .password(password)
                .email(email)
                .build();

        studentRepository.save(students);
        resp.sendRedirect("/students_with_tags.jsp");
    }
}