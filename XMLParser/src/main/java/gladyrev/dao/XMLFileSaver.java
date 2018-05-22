package gladyrev.dao;

import gladyrev.models.Position;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

import org.xml.sax.SAXException;
/**
 * Интерфейс PositionDataBaseDao для создания xml файлов
 */
public interface XMLFileSaver {
    void saveToFile(Map<String, Position> positionHashMap, String fileName) throws ParserConfigurationException, SAXException, IOException;
}