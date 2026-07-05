package com.forma.api.domain.model;

import com.forma.api.domain.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "personal")
@Data
public class Personal {

    @Id
    private UUID id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "cref", unique = true)
    private String cref;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    @PrePersist
    public void prePersist(){
        this.user.setUserType(Role.PERSONAL);
    }
}
