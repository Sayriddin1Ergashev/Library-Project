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
    @GeneratedValue(generator = "author_seq_id")
    @SequenceGenerator(name = "author_seq_id",sequenceName = "author_seq_id",allocationSize = 1)
    private Integer authorId;
    private String firstname;
    private String lastname;
    private Integer booksId;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
