package com.shortenServer.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "links")
public class LinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String slug;

    private final LocalDateTime dateCreated = LocalDateTime.now();

    private final LocalDateTime dateModified = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private UserEntity user;

}
