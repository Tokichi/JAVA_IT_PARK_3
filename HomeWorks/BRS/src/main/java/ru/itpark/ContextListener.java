package ru.itpark;

import ru.itpark.dao.StudentDao;
import ru.itpark.dao.StudentRepositoryEntityManagerImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("ru.itpark.persistence");

        StudentDao studentRepository = new StudentRepositoryEntityManagerImpl(factory.createEntityManager());

        servletContextEvent.getServletContext().setAttribute("studentDao", studentRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}