package gladyrev;

import gladyrev.menu.Menu;
import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileReader;
import java.util.*;
import java.io.IOException;

/**
 * Класс Program, основной класс, содержит в себе метод main - точку входа в программу
 */
public class Program {

    private static final Logger logger = Logger.getLogger(Program.class);

    /**
     * Метод main - точка входа в программу
     */
    public static void main(String[] args) {

        logger.info("Program is running");
/**
 * Создается экземпляр класса Properties для получения параметров подключения к базе данных из файла application.properties
 */
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
/**
 * Создается экземпляр класса DriverManagerDataSource - dataSource, куда помещаем параметры подключения к базе данных, полученных из файла application.properties
 */
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(properties.getProperty("datasource.name"));
        dataSource.setPassword(properties.getProperty("datasource.password"));
        dataSource.setUrl(properties.getProperty("datasource.url"));
        dataSource.setDriverClassName(properties.getProperty("datasource.driver"));
/**
 * В класс Menu передается объект dataSource, содержащий параметры подключения к базе данных
 */
        Menu.setDataSource(dataSource);
/**
 * Вызывается статический метод showMainMenu класса Menu
 */
        Menu.showMainMenu();
    }
}
