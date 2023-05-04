package com.company.LibraryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImagesDto {
    private Integer imageId;
    @NotBlank(message = "Path cannot be empty or null!")
    private String path;
    @NotBlank(message = "Type cannot be empty or null!")
    private String type;
    private Integer size;
    @NotBlank(message = "Token cannot be empty or null!")
    private String token;
    private Integer booksId;
    private BooksDto books;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;


}
