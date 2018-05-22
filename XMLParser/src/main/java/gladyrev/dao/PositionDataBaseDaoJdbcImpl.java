package gladyrev.dao;

import gladyrev.models.Position;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс PositionDataBaseDaoJdbcImpl реализует интерфейс PositionDataBaseDao для работы с базой данных
 */
public class PositionDataBaseDaoJdbcImpl implements PositionDataBaseDao {
    private static final Logger logger = Logger.getLogger(PositionDataBaseDaoJdbcImpl.class);

    //language=SQL
    private static final String SQL_SELECT_POSITIONS = "SELECT * from positions";

    //language=SQL
    private static final String SQL_INSERT_POSITION =
            "INSERT INTO positions(depcode, depjob, description)" + "VALUES (?, ?, ?)";

    //language=SQL
    private static final String SQL_UPDATE_POSITION =
            "UPDATE positions SET description = ? WHERE depcode = ? AND  depjob = ?";

    //language=SQL
    private static final String SQL_DELETE_POSITION = "DELETE FROM positions WHERE id = ?";

    private JdbcTemplate template;

    private Map<String, Position> positionsMap;

    public PositionDataBaseDaoJdbcImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.positionsMap = new HashMap<String, Position>();
    }

    /**
     * В методе RowMapper происходит преобразование строк база данных в экземпляры класса Position
     */
    private RowMapper<Position> humanRowMapper = new RowMapper<Position>() {
        //        @Override
        public Position mapRow(ResultSet resultSet, int i) throws SQLException {
            Position position = new Position();
            position.setId(resultSet.getInt(1));
            position.setDepCode(resultSet.getString(2));
            position.setDepJob(resultSet.getString(3));
            position.setDescription(resultSet.getString(4));

            positionsMap.put(position.getDepCode() + position.getDepJob(), position);
            return position;
        }

    };

    /**
     * Метод findAll отправляет запрос на получение всех строк из таблицы базы данных positions и возвращает Map
     * в котором в качествет ключа используется суммы строк DepCode + DepJob, а в качестве значения экземпляры класса Position
     */
    public Map<String, Position> findAll() {
        template.query(SQL_SELECT_POSITIONS, humanRowMapper);
        return positionsMap;
    }

    /**
     * Метод synchronize выполняет сохранение в базе данных позиций из Map'a positionForSave,
     * изменение в базе данных позиций из List'a positionsForUpdate и удаление в базе данных позиций из Map'a positionForDelete
     * Все операции в методе выполняются в рамках одной транзакции, для этого была добавлена аннотация @Transactional
     */
    @Transactional
    public void synchronize(Map<String, Position> positionForSave, List<Position> positionsForUpdate, Map<String, Position> positionForDelete) {
        for (Map.Entry<String, Position> positionEntry : positionForSave.entrySet()) {
            template.update(SQL_INSERT_POSITION,
                    positionEntry.getValue().getDepCode(),
                    positionEntry.getValue().getDepJob(),
                    positionEntry.getValue().getDescription());
            logger.info("В базу данных добавлена позиция " + positionEntry.getValue().toString());
        }
        for (Position position : positionsForUpdate) {
            template.update(SQL_UPDATE_POSITION, position.getDescription(), position.getDepCode(), position.getDepJob());
            logger.info("В базе данных изменена позиция " + position.toString());
        }
        for (Map.Entry<String, Position> positionEntry : positionForDelete.entrySet()) {
            template.update(SQL_DELETE_POSITION, positionEntry.getValue().getId());
            logger.info("В базе данных удалена позиция " + positionEntry.getValue().toString());
        }
        System.out.println("Синхронизация данных успешно выполнена");
        System.out.println("Позиций добавлено: " + positionForSave.size());
        System.out.println("Позиций удалено: " + positionForDelete.size());
        System.out.println("Позиций отредактировано: " + positionsForUpdate.size());
        logger.info("Синхронизация данных успешно выполнена");
        logger.info("Позиций добавлено: " + positionForSave.size());
        logger.info("Позиций удалено: " + positionForDelete.size());
        logger.info("Позиций отредактировано: " + positionsForUpdate.size());
    }
}
