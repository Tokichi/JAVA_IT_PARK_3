package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByOrderById();
}