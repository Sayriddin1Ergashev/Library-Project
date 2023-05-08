package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "images")
public class Images {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "image", sequenceName = "image", allocationSize = 1)
    private Integer imageId;
    private String path;
    private String type;
    private Integer size;
    private String token;
    private Integer booksId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Integer bookId;  // TODO: xoato tashagani uchun qushdim
}
