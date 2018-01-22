package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.models.Student;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}