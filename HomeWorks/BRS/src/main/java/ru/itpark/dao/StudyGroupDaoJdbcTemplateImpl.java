package ru.itpark.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itpark.models.StudyGroup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudyGroupDaoJdbcTemplateImpl implements StudyGroupDao {

    //language=SQL
    private static final String SQL_INSERT_GROUP = "INSERT INTO study_group (name)" + "VALUES (?)";
    //language=SQL
    private static final String SQL_SELECT_GROUP_BY_ID = "SELECT * FROM study_group WHERE id = ?";
    //language=SQL
    private static final String SQL_UPDATE_GROUP_BY_ID = "UPDATE study_group SET name = ? WHERE id = ?";
    //language=SQL
    private static final String SQL_DELETE_GROUP_BY_ID = "DELETE FROM study_group WHERE id = ?";

    private JdbcTemplate template;

    public StudyGroupDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<StudyGroup> groupRowMapper = new RowMapper<StudyGroup>() {
        @Override
        public StudyGroup mapRow(ResultSet resultSet, int i) throws SQLException {
            StudyGroup group = StudyGroup.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .build();
            return group;
        }
    };

    public void save(StudyGroup model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_GROUP, new String[]{"id"});
                        preparedStatement.setString(1, model.getName());
                        return preparedStatement;
                    }
                }, keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    public StudyGroup find(int id) {
        try {
            return template.queryForObject(SQL_SELECT_GROUP_BY_ID, groupRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Группа с id <" + id + "> не найдена");
        }
    }

    public void update(final StudyGroup model) {
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_GROUP_BY_ID);
                preparedStatement.setString(1, model.getName());
                preparedStatement.setLong(2, model.getId());
                return preparedStatement;
            }
        });
    }

    public void delete(int id) {
        template.update(SQL_DELETE_GROUP_BY_ID, id);
    }

    public List<StudyGroup> findAll() {
        return null;
    }
}
