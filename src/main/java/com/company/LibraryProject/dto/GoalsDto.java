package com.company.LibraryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoalsDto {
    private Integer goalsId;
    @NotBlank(message = "Language cannot be empty or null!")
    private String language;
    @NotBlank(message = "Name cannot be empty or null!")
    private String name;
    private Integer booksId;
    private BooksDto books;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
