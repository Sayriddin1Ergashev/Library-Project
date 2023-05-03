package com.company.LibraryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDto {
    private Integer imageId;
    @NotBlank(message = "Path cannot be empty or null!")
    private String path;
    @NotBlank(message = "Type cannot be empty or null!")
    private String type;
    @NotNull(message = "Size cannot be null")
    //@Size(min = 1,max = 255,message = "Size error!")
    private Integer size;
    @NotBlank(message = "Token cannot be empty or null!")
    private String token;
    private Integer booksId;
    private BooksDto books;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
