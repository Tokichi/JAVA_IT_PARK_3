package gladyrev.dao;

import gladyrev.models.Position;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
/**
 * Интерфейс PositionDataBaseDao для чтения xml файлов
 */
public interface XMLFileReader {
    Map<String, Position> readFile(String fileName) throws ParserConfigurationException, SAXException, IOException;
}
