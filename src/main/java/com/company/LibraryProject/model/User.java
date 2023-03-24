package com.company.LibraryProject.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private Integer userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Gender gender;
    private Card card;
    private Integer age;
    private Integer cardId;
    private String phoneNumber;
    private LocalDate birthdate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
