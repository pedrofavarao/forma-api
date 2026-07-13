package com.forma.api.domain.repository;

import com.forma.api.domain.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

    @Query("""
    SELECT DISTINCT p
    FROM Personal p
    JOIN FETCH p.user
    LEFT JOIN FETCH p.students s
    LEFT JOIN FETCH s.user
    WHERE p.id = :id
    """)
    Optional<Personal> findById(@Param("id") UUID id);

    @Query("""
    SELECT p
    FROM Personal p
    JOIN FETCH p.user
    WHERE p.user.email = :email
    """)
    Optional<Personal> findByUserEmail(@Param("email") String email);

    @Query("""
    SELECT p
    FROM Personal p
    JOIN FETCH p.user
    WHERE p.user.username = :username
    """)
    Optional<Personal> findByUserUsername(@Param("username") String username);

    @Query("""
    SELECT DISTINCT p
    FROM Personal p
    JOIN FETCH p.user
    LEFT JOIN FETCH p.students s
    LEFT JOIN FETCH s.user
    WHERE p.cref = :cref
    """)
    Optional<Personal> findByCref(@Param("cref") String cref);

    void deleteById(UUID id);

    @Query("""
    SELECT DISTINCT p
    FROM Personal p
    JOIN FETCH p.user
    LEFT JOIN FETCH p.students s
    LEFT JOIN FETCH s.user
    WHERE p.id = :id
""")
    Optional<Personal> findCompleteById(@Param("id") UUID id);

    @Query("""
    SELECT p
    FROM Personal p
    JOIN FETCH p.user
    """)
    List<Personal> findAll();
}
