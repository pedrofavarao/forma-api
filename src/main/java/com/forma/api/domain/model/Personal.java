package com.forma.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "personal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personal {

    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL
//    orphanRemoval = true
    )
    @MapsId
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "cref", unique = true)
    private String cref;

    @JsonIgnore
    @OneToMany(mappedBy = "personal")
    private List<Student> students;
}
