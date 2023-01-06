package com.shortenServer.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
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

    private LocalDateTime dateCreated;

    private LocalDateTime dateModified;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity user;

}
