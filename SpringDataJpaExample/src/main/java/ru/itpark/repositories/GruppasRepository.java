package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.models.Gruppa;

import java.util.List;

public interface GruppasRepository extends JpaRepository<Gruppa, Long> {
}