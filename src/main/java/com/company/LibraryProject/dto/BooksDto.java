package com.company.LibraryProject.dto;

import com.company.LibraryProject.model.Authors;
import com.company.LibraryProject.model.Goals;
import com.company.LibraryProject.model.Images;
import com.company.LibraryProject.model.Publisher;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class BooksDto {
    private Integer bookId;
    @NotBlank(message = "name cannot be null or empty")
    private String name;
    @NotNull(message = "price cannot be null")
    private Double price;
    @NotNull(message = "page cannot be null")
    private Integer page;
    @NotNull(message = "amount cannot be null")
    private Integer amount;
    private LocalDate publisherAt;
    private Set<AuthorDto> authorsDto;
    private Set<ImagesDto> imagesDto;
    private GoalsDto goalsDto;
    private PublisherDto publisherDto;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
