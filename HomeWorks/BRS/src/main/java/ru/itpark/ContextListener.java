package ru.itpark;

import ru.itpark.repository.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("ru.itpark.persistence");

        StudentsRepository studentsRepository = new StudentsRepositoryEntityManagerImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("studentsRepository", studentsRepository);

        TeachersRepository teachersRepository = new TeachersRepositoryEntityManagerImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("teachersRepository", teachersRepository);

        GroupsRepository groupsRepository = new GroupsRepositoryEntityManagerImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("groupsRepository", groupsRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}