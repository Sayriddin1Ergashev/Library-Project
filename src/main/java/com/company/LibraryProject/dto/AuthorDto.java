package com.company.LibraryProject.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AuthorDto {
    private Integer authorId;
    private String firstname;
    private String lastname;
    private Integer age;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
