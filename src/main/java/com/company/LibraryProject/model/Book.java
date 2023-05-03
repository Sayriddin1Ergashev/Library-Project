package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "books_id")
    private Integer bookId;
    private String name;
    private Double price;
    private Integer page;
    private Integer amount;
    private LocalDate publisherAt;

    @OneToMany(mappedBy = "authorId", cascade = CascadeType.ALL)
    private Set<Authors> authors;

    @OneToMany(mappedBy = "imageId", cascade = CascadeType.ALL)
    private Set<Images> images;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_id", referencedColumnName = "books_id")
    private Goals goals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_id", referencedColumnName = "books_id")
    private Publisher publisher;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
