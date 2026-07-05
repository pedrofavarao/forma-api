package com.forma.api.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    private UUID id;

    @MapsId
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Personal professor;
}
