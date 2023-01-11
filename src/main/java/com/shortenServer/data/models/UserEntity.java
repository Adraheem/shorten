package com.shortenServer.data.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String username;

    @Nonnull
    private String fullName;

    @Nonnull
    private String password;

    private LocalDateTime dateCreated = LocalDateTime.now();

    private LocalDateTime dateUpdated = LocalDateTime.now();

    @Nonnull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RoleEntity> roles = new ArrayList<>();

}
