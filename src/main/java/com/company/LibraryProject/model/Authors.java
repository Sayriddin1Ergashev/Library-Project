package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("authors"))
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(allocationSize = 2, sequenceName = "authors_seq_id", name = "authors_seq_id")
    private Integer authorId;
    private String firstname;
    private String lastname;
    private Integer age;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;



}
