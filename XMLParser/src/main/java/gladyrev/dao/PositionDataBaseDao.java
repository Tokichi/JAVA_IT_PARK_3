package gladyrev.dao;

import gladyrev.models.Position;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс PositionDataBaseDao для работы с базой данных
 */
public interface PositionDataBaseDao {
    /**
     * Метод findAll выгружает из базы данных позиции и помещает их в HashMap, который затем и возвращает
     */
    Map<String, Position> findAll();

    /**
     * Метод synchronize выполняет сохранение в базе данных позиций из Map'a positionForSave,
     * изменение в базе данных позиций из List'a positionsForUpdate и удаление в базе данных позиций из Map'a positionForDelete
     */
    void synchronize(Map<String, Position> positionForSave, List<Position> positionsForUpdate, Map<String, Position> positionForDelete);
}
