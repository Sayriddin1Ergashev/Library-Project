package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("publishers"))
public class Publisher {
    @Id
    @GeneratedValue(generator = "publisher_seq_id")
    @SequenceGenerator(name = "publisher_seq_id",sequenceName = "publisher_seq_id",allocationSize = 1)
    private Integer publisherId;
    private String publisher;
    private String location;
    private Integer booksId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
