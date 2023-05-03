package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name ="goals" )
public class Goals {
    @Id
    @GeneratedValue(generator = "goals_seq_id")
    @SequenceGenerator(name = "goals_seq_id",sequenceName = "goals_seq_id",allocationSize = 1)
    private Integer goalsId;
    private String language;
    private Integer booksId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
