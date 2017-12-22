package ru.itpark.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.itpark.models.Student;

import static org.junit.Assert.*;

public class StudentDaoJdbcTemplateImplTest {
    private StudentDaoJdbcTemplateImpl testedStudentDao;

    @Before
    public void setUp() throws Exception {
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema_student.sql")
                .addScript("data_student.sql")
                .build();

        testedStudentDao = new StudentDaoJdbcTemplateImpl(database);
    }

    @Test
    public void findTest() throws Exception {
        Student expected = Student.builder()
                .id(1)
                .name("Василий")
                .surname("Васильев")
                .patronymic("Васильевич")
                .login("vasya")
                .password("12345")
                .email("vasya@mail.ru")
                .build();

        Student actual = testedStudentDao.find(1);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedStudentDao.find(6);
    }

    @Test
    public void saveTest() throws Exception {
        Student expected = Student.builder()
                .id(4)
                .name("Михаил")
                .surname("Михайлов")
                .patronymic("Михайлович")
                .login("misha")
                .password("12345")
                .email("misha@mail.ru")
                .build();

        testedStudentDao.save(expected);
        Student actual = testedStudentDao.find(4);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest() throws Exception {
        testedStudentDao.delete(1);
        Student expected = null;
        Student actual = testedStudentDao.find(1);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void updateTest() throws Exception {
        Student expected = Student.builder()
                .id(1)
                .name("Михаил")
                .surname("Михайлов")
                .patronymic("Михайлович")
                .login("misha")
                .password("12345")
                .email("misha@mail.ru")
                .build();
        testedStudentDao.update(expected);
        Student actual = testedStudentDao.find(1);

        Assert.assertEquals(expected, actual);
    }
}

