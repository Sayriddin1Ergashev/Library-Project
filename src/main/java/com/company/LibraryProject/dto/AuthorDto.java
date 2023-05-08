package com.company.LibraryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)// TODO: json qushdim
public class AuthorDto {
    private String authorId;
    private String firstname;
    private String lastname;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Integer bookId;  // TODO: xato tashagani uchun qushdim

}
