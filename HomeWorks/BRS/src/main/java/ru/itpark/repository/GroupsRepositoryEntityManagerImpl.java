package ru.itpark.repository;

import ru.itpark.models.Group;

import javax.persistence.EntityManager;
import java.util.List;

public class GroupsRepositoryEntityManagerImpl implements GroupsRepository {

    private EntityManager entityManager;

    public GroupsRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Group> findAll() {
        return entityManager
                .createQuery("from StudyGroup studyGroup order by studygroup.id", Group.class)
                .getResultList();
    }

    @Override
    public void save(Group model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }
}