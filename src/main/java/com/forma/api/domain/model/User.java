package com.forma.api.domain.model;

import com.forma.api.domain.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "forma_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role userType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
