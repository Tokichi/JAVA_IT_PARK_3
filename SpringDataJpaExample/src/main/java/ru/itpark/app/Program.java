package ru.itpark.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itpark.config.ApplicationContext;
import ru.itpark.models.*;
import ru.itpark.repositories.*;

public class Program {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ApplicationContext.class);
//        Gruppa gruppa = Gruppa.builder()
//                .name("01")
//                .build();
//
//        Student student = Student.builder()
//                .name("Vasya")
//                .surname("Vasilev")
//                .patronymic("Vasilevich")
//                .login("vasya")
//                .password("12345")
//                .email("vasya@mail.ru")
//                .build();
//        student.setGruppa(gruppa);
//        GroupsRepository usersRepository = context.getBean(GroupsRepository.class);
//        usersRepository.save(gruppa);
//        StudentsRepository studentsRepository = context.getBean(StudentsRepository.class);
//        studentsRepository.save(student);

        Student student = Student.builder()
                .name("sdfsd")
                .surname("sdfsd")
                .patronymic("sdfsd")
                .login("sdfsd")
                .password("sdfsd")
                .email("sdfsd")
                .build();

        Gruppa gruppa = Gruppa.builder()
                .name("23")
                .build();

        student.setGruppa(gruppa);

        GruppasRepository gruppasRepository = context.getBean(GruppasRepository.class);
        gruppasRepository.save(gruppa);
        StudentsRepository studentsRepository = context.getBean(StudentsRepository.class);
        studentsRepository.save(student);
    }
}
