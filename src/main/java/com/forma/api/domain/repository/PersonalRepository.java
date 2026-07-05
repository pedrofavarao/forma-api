package com.forma.api.domain.repository;

import com.forma.api.domain.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
    Optional<Personal> findById(UUID id);
    Optional<Personal> findByUserEmail(String email);
    Optional<Personal> findByUserUsername(String username);
    Optional<Personal> findByCref(String cref);
    void deleteById(UUID id);
}
