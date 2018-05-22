package gladyrev.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import gladyrev.menu.Menu;
import gladyrev.models.Position;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Класс XMLFileReaderImpl реализует интерфейс XMLFileReader для чтения xml файлов
 */
public class XMLFileReaderImpl implements XMLFileReader {
    private static final Logger logger = Logger.getLogger(XMLFileReaderImpl.class);

    /**
     * Метод readFile получает строку с именем xml-файла который требуется прочесть и преобразует элементы
     * xml-файла в экземпляры класса Position которые помещает в Map в качестве значений и в качестве ключей используются
     * суммы строк DepCode + DepJob
     */
    public Map<String, Position> readFile(String fileName) throws ParserConfigurationException, SAXException, IOException {
        final File xmlFile = new File(System.getProperty("user.dir") + File.separator + fileName);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse(xmlFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл с именем '" + fileName + "' не найден");
            logger.warn("Файл с именем '" + fileName + "' не найден");
            Menu.showMainMenu();
        }

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("Positoin");
        Map<String, Position> positionMap = new HashMap<String, Position>();
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);
            Position position = new Position();

            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;
                position.setDepCode(element
                        .getElementsByTagName("DepCode").item(0)
                        .getTextContent());
                position.setDepJob(element
                        .getElementsByTagName("DepJob").item(0)
                        .getTextContent());
                position.setDescription(element
                        .getElementsByTagName("Description").item(0)
                        .getTextContent());
            }

            if (positionMap.containsKey(position.getDepCode() + position.getDepJob())) {
                System.out.println("В файле дублируется позиция: " + position.toString());
                logger.warn("В файле дублируется позиция: " + position.toString());
            } else {
                positionMap.put(position.getDepCode() + position.getDepJob(), position);
            }
        }
        return positionMap;
    }
}
