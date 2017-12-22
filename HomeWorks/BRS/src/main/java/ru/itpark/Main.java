package ru.itpark;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.dao.StudentDao;
import ru.itpark.dao.StudentDaoJdbcTemplateImpl;
import ru.itpark.models.Student;
import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);

        StudentDao studentDao = new StudentDaoJdbcTemplateImpl(dataSource);
//        Student student = studentDao.find(1);
//        System.out.println(student);
//        Student student = Student.builder()
//                .name("Артем")
//                .surname("Гладырев")
//                .patronymic("Сергеевич")
//                .login("gladyrev")
//                .password("3543343")
//                .email("gladyrev@mail.ru")
//                .id(1)
//                .build();
//        studentDao.update(student);
        studentDao.find(1);
    }
}
