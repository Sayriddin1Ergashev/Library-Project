package com.company.LibraryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublisherDto {
    private Integer publisherId;
    @NotBlank(message = "Publisher cannot be empty or null!")
    private String publisher;
    @NotBlank(message = "Location cannot be empty or null!")
    private String location;
    private Integer booksId;
    private BooksDto books;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
