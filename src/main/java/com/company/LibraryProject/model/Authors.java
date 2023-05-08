package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "authors") // TODO s qolib kitibdi qushib quydim
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id") // TODO s qolib kitibdi qushib quydim
    private Integer authorId;
    private String firstname;
    private String lastname;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private Integer bookId;  // TODO: xoato tashagani uchun qushdim
}
