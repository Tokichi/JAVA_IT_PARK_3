package gladyrev.menu;

import gladyrev.dao.*;
import gladyrev.models.Position;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

/**
 * Класс Menu отвечает за работу консольного меню
 */
public class Menu {
    private static final Logger logger = Logger.getLogger(Menu.class);
    private static Scanner scanner = new Scanner(System.in);
    private static PositionDataBaseDao positionDataBaseDao;

    public static void setDataSource(DataSource dataSource) {
        positionDataBaseDao = new PositionDataBaseDaoJdbcImpl(dataSource);
    }

    /**
     * Метод showMainMenu - отвечает за работу главного меню
     */
    public static void showMainMenu() {
        while (true) {
            System.out.println("МЕНЮ:");
            System.out.println("1. Выгрузить содержимого таблицы БД в XML файл (нажмите '1')");
            System.out.println("2. Синхронизацировать содержимое таблицы БД по заданному XML файлу (нажмите '2')");

            String mainMenucommand;

            mainMenucommand = scanner.nextLine();
/** Производится проверка введенной команды*/
            if (!(mainMenucommand.equals("1") || mainMenucommand.equals("2"))) {
                logger.warn("Введена неверная команда '" + mainMenucommand + "' в главном меню");
                System.out.println("Команды '" + mainMenucommand + "' не существует");
                continue;
            } else {

                while (true) {

                    switch (Integer.parseInt(mainMenucommand)) {
                        case 1: {
                            saveXMLMenu();
                        }
                        case 2: {
                            readXMLMenu();
                        }
                        break;
                    }
                    scanner.nextLine();
                    break;
                }
            }
        }
    }

    /**
     * Метод saveXMLMenu отвечает за часть меню, отвечающей за выгрузку данных базы данных в xml файл
     */
    public static void saveXMLMenu() {
        while (true) {
            System.out.println("МЕНЮ:");
            System.out.println("1. Использовать для выгрузки файл с именем по умолчанию 'positions' (нажмите '1')");
            System.out.println("2. Задать имя файла для выгрузки самостоятельно (нажмите '2')");
            System.out.println("3. Вернуться в главное меню (нажмите '3')");
            String saveXMLCommand;
            saveXMLCommand = scanner.nextLine();

            if (!(saveXMLCommand.equals("1") || saveXMLCommand.equals("2") || saveXMLCommand.equals("3"))) {
                logger.warn("Введена неверная команда '" + saveXMLCommand + "' в меню выгрузки данных в файл");
                System.out.println("Команды '" + saveXMLCommand + "'nне существует");
                continue;
            } else {
                String nameFileToSave = "positions";

                switch (Integer.parseInt(saveXMLCommand)) {
                    case 1: {
                        break;
                    }

                    case 2: {
                        System.out.println("Введите имя файла в который будет выгружено содержимое БД (без расширения файла)");
                        nameFileToSave = scanner.next();
                        break;
                    }
                    case 3: {
                        showMainMenu();
                    }

                }
                Map<String, Position> positionMapfromDB = positionDataBaseDao.findAll();
                XMLFileSaver fileSaver = new XMLFileSaverImpl();
                try {
                    fileSaver.saveToFile(positionMapfromDB, nameFileToSave);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scanner.nextLine();
                showMainMenu();
            }

        }
    }
    /**
     * Метод saveXMLMenu отвечает за часть меню, отвечающей за синхронизацию содержимого таблицы БД по xml файлу
     */
    public static void readXMLMenu() {
        XMLFileReader xmlFileReader = new XMLFileReaderImpl();
        System.out.println("Введите имя файла по содержимому которого будет осуществляться синхронизация данных (без расширения файла)");
        String fileToLoadName = scanner.next();

        Map<String, Position> positionMapFromFile = null;
        scanner.nextLine();
        try {
            positionMapFromFile = xmlFileReader.readFile(fileToLoadName + ".xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Position> positionMapfromDB = positionDataBaseDao.findAll();

        List<Position> positionsForUpdate = new LinkedList<Position>();
        List<String> keys = new LinkedList<String>();
        for (Map.Entry<String, Position> entry : positionMapFromFile.entrySet()) {
            if (positionMapfromDB.containsKey(entry.getKey())) {
                if (entry.getValue().getDescription().equals(positionMapfromDB.get(entry.getKey()).getDescription())) {
                    positionMapfromDB.remove(entry.getKey());
                    keys.add(entry.getKey());
                } else {
                    positionsForUpdate.add(positionMapFromFile.get(entry.getKey()));
                    positionMapfromDB.remove(entry.getKey());
                    keys.add(entry.getKey());
                }
            }
        }
        for (String key : keys) {
            positionMapFromFile.remove(key);
        }

        positionDataBaseDao.synchronize(positionMapFromFile, positionsForUpdate, positionMapfromDB);
        scanner.nextLine();
        showMainMenu();
    }
}
