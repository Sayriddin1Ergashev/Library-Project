package com.company.LibraryProject.dto;

import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.model.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private Integer userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDateTime birthdate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Gender gender;
}
