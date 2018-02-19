package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplinesRepository extends JpaRepository<Discipline, Long> {
    List<Discipline> findByOrderById();
    List<Discipline> findByOrderByName();

}