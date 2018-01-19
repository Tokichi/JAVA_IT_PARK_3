package ru.itpark;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.dao.GroupDaoJdbcTemplateImpl;
import ru.itpark.dao.StudentDao;
import ru.itpark.dao.StudentDaoJdbcTemplateImpl;
import ru.itpark.dao.TeacherDaoJdbcTemplateImpl;
import ru.itpark.models.Group;
import ru.itpark.models.Student;
import ru.itpark.models.Teacher;
import ru.itpark.repository.GroupsRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;
//
public class Main {
    public static void main(String[] args) {
        
    }
}
