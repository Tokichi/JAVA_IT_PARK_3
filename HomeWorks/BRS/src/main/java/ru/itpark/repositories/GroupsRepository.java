package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.Group;

import java.util.List;
import java.util.Optional;

public interface GroupsRepository extends JpaRepository<Group, Long> {
    List<Group> findByOrderById();
    List<Group> findByOrderByName();

}