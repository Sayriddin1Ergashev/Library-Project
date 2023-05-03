package com.company.LibraryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDto {
    private Integer authorId;
    @NotBlank(message = "FirstName cannot be empty or null!")
    private String firstname;
    @NotBlank(message = "LastName cannot be empty or null!")
    private String lastname;
    @NotNull(message ="Age cannot be null!" )
    private Integer age;
    private Integer booksId;
    private BooksDto books;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
