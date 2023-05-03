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
@Table(name = ("books"))
public class Books {
    @Id
    @GeneratedValue(generator = "books_seq_id")
    @SequenceGenerator(name = "books_seq_id", sequenceName = "books_seq_id", allocationSize = 1)
    private Integer booksId;
    private String name;
    private Integer ordersBookId;
    private Integer authorId;
    @OneToOne
 //   @JoinColumn(referencedColumnName = "author_id", insertable = false, updatable = false, unique = true)
    private Author author;
    @OneToMany(mappedBy = "booksId",cascade = CascadeType.ALL)
    private Set<Goals> goals;
    private Integer imageId;
    @OneToOne(mappedBy = "books")
   // @JoinColumn(name = "imageId", referencedColumnName = "booksId")
    private Image image;
    private Integer publisherId;
    @OneToOne
  // @JoinColumn(name = "publisher_id", insertable = false, updatable = false, unique = true)
    private Publisher publisher;
    private Float price;
    private Integer page;
    private LocalDate published;
    private Float amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


}
