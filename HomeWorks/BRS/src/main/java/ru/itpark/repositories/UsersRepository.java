package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.Role;
import ru.itpark.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findByOrderById();
    List<User> findByOrderByName();
    List<User> findAllByRole(Role role);
    Optional<User> findByEmail(String email);

}