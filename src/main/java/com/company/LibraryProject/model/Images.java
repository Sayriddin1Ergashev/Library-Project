package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("images"))
public class Images {
    @Id
    @Column(name = ("image_id"))
    @GeneratedValue(generator ="image_seq_id")
    @SequenceGenerator(name = "image_seq_id",sequenceName = "image_seq_id",allocationSize = 1)
    private Integer imageId;
    private String path;
    private String type;
    private Integer size;
    private String token;
    private Integer booksId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Integer bookId;
}
