package com.forma.api.domain.repository;

import com.forma.api.domain.model.Personal;
import com.forma.api.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findById(UUID id);
    Optional<Student> findByUserEmail(String email);
    Optional<Student> findByUserUsername(String username);
    void deleteById(UUID id);
}
