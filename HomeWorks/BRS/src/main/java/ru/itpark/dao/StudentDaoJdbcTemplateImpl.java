package ru.itpark.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import ru.itpark.models.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoJdbcTemplateImpl implements StudentDao {

    //language=SQL
    private static final String SQL_SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
    //language=SQL
    private static final String SQL_UPDATE_STUDENT_BY_ID = "UPDATE student SET name = ?, surname = ?, patronymic = ?, login = ?, password = ?, email= ? WHERE id = ?";
    //language=SQL
    private static final String SQL_DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?";

    private JdbcTemplate template;

    public StudentDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Student> studentRowMapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = Student.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .patronymic(resultSet.getString("patronymic"))
                    .login(resultSet.getString("login"))
                    .password(resultSet.getString("password"))
                    .email(resultSet.getString("email"))
                    .build();
            return student;
        }
    };

    public List<Student> findAllByGroup(String group) {
        return null;
    }

    public void save(Student model) {
    }

    public Student find(int id) {
        try {
            return template.queryForObject(SQL_SELECT_STUDENT_BY_ID, studentRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Студент с id <" + id + "> не найден");
        }
    }

    public void update(final Student model) {
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_STUDENT_BY_ID);
                preparedStatement.setString(1, model.getName());
                preparedStatement.setString(2, model.getSurname());
                preparedStatement.setString(3, model.getPatronymic());
                preparedStatement.setString(4, model.getLogin());
                preparedStatement.setString(5, model.getPassword());
                preparedStatement.setString(6, model.getEmail());
                preparedStatement.setLong(7, model.getId());
                return preparedStatement;
            }
        });
    }

    public void delete(int id) {
        template.update(SQL_DELETE_STUDENT_BY_ID, id);
    }

    public List<Student> findAll() {
        return null;
    }
}
