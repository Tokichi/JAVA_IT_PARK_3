//package ru.itpark.dao;
//
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.RowMapper;
//import ru.itpark.models.Teacher;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//public class TeacherDaoJdbcTemplateImpl implements TeacherDao {
//
//    //language=SQL
//    private static final String SQL_SELECT_TEACHER_BY_ID = "SELECT * FROM teacher WHERE id = ?";
//    //language=SQL
//    private static final String SQL_UPDATE_TEACHER_BY_ID = "UPDATE teacher SET name = ?, surname = ?, patronymic = ?, login = ?, password = ?, email= ? WHERE id = ?";
//    //language=SQL
//    private static final String SQL_DELETE_TEACHER_BY_ID = "DELETE FROM teacher WHERE id = ?";
//
//    private JdbcTemplate template;
//
//    public TeacherDaoJdbcTemplateImpl(DataSource dataSource) {
//        this.template = new JdbcTemplate(dataSource);
//    }
//
//    private RowMapper<Teacher> teacherRowMapper = new RowMapper<Teacher>() {
//        @Override
//        public Teacher mapRow(ResultSet resultSet, int i) throws SQLException {
//            Teacher teacher = Teacher.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .surname(resultSet.getString("surname"))
//                    .patronymic(resultSet.getString("patronymic"))
//                    .login(resultSet.getString("login"))
//                    .password(resultSet.getString("password"))
//                    .email(resultSet.getString("email"))
//                    .build();
//            return teacher;
//        }
//    };
//
//    public List<Teacher> findAllByGroup(String group) {
//        return null;
//    }
//
//    public void save(Teacher model) {
//    }
//
//    public Teacher find(int id) {
//        try {
//            return template.queryForObject(SQL_SELECT_TEACHER_BY_ID, teacherRowMapper, id);
//        } catch (EmptyResultDataAccessException e) {
//            throw new IllegalArgumentException("Преподаватель с id <" + id + "> не найден");
//        }
//    }
//
//    public void update(final Teacher model) {
//        template.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_TEACHER_BY_ID);
//                preparedStatement.setString(1, model.getName());
//                preparedStatement.setString(2, model.getSurname());
//                preparedStatement.setString(3, model.getPatronymic());
//                preparedStatement.setString(4, model.getLogin());
//                preparedStatement.setString(5, model.getPassword());
//                preparedStatement.setString(6, model.getEmail());
//                preparedStatement.setLong(7, model.getId());
//                return preparedStatement;
//            }
//        });
//    }
//
//    public void delete(int id) {
//        template.update(SQL_DELETE_TEACHER_BY_ID, id);
//    }
//
//    public List<Teacher> findAll() {
//        return null;
//    }
//}
