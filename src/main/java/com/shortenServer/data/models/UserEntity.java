package com.shortenServer.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RoleEntity> roles = new ArrayList<>();

}
