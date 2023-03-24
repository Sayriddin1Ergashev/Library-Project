package com.company.LibraryProject.dto;

import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.model.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

//DTO -> Data Transfer Object
@Getter
@Setter
public class UserDto {
    private Integer userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Integer age;
    private Gender gender;
    private Card card;
    private Integer cardId;
    private String phoneNumber;
    private LocalDate birthdate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
