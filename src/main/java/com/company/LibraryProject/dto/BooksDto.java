package com.company.LibraryProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BooksDto {
    private Integer bookId;
    private String name;
    private Double price;
    private Integer page;
    private Integer amount;
    private LocalDate publisherAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
