package gladyrev.dao;

import gladyrev.menu.Menu;
import gladyrev.models.Position;

import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.util.Map;
/**
 * Класс XMLFileSaverImpl реализует интерфейс PositionDataBaseDao для создания xml файлов
 */
public class XMLFileSaverImpl implements XMLFileSaver {
    private static final Logger logger = Logger.getLogger(XMLFileSaverImpl.class);

    /**
     * Метод saveToFile получает Мар positionHashMap, и строку с именем будущего xml-файла fileName,
     * значениями Мар'a являются эжкземпляры класса Position, которые преобразуются в элементы xml-файла,
     * затем все это записывается в новосозданный xml-файл
     */
    public void saveToFile(Map<String, Position> positionHashMap, String fileName) throws IOException {

        Document document = new Document();
        document.setRootElement(new Element("Positoins"));

        for (Map.Entry<String, Position> entry : positionHashMap.entrySet()) {

            Element positoinElement = new Element("Positoin");
            positoinElement.addContent(new Element("DepCode").setText(entry.getValue().getDepCode()));
            positoinElement.addContent(new Element("DepJob").setText(entry.getValue().getDepJob()));
            positoinElement.addContent(new Element("Description").setText(entry.getValue().getDescription()));
            document.getRootElement().addContent(positoinElement);
            logger.info("В файл добавлена позиция " + entry.getValue().toString());

        }
        XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".xml");

        xmlWriter.output(document, fileOutputStream);
        fileOutputStream.close();

        logger.info("Файл " + fileName + ".xml" + " успешно создан, выгружено позиций: " + positionHashMap.size());
        System.out.println("Файл " + fileName + ".xml" + " успешно создан, выгружено позиций: " + positionHashMap.size());
        Menu.showMainMenu();
    }
}
