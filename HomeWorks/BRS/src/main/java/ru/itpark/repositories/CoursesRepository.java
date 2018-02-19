package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.Course;

import java.util.List;
import java.util.Optional;

public interface CoursesRepository extends JpaRepository<Course, Long> {
        List<Course> findByOrderById();
        }