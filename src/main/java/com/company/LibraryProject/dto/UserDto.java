package com.company.LibraryProject.dto;

import com.company.LibraryProject.model.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer userId;
    @NotBlank(message = "firstname cannot be null or empty")
    private String firstName;
    @NotBlank(message = "lastname cannot be null or empty")
    private String lastName;
    @Email(message = "Email invalid")
    private String email;
    @NotBlank(message = "password cannot be null or empty")
    @Size(min = 6, max = 10, message = "password  invalid")
    //@Pattern(regexp = "[a-zA-Z0-9]{6}", message = "Regular expression error.")
    //@Pattern(regexp = "[a-z]{1,3}[A-Z]{1,7}[0-9]{1,6}", message = "Regular expression error.")
    @Pattern(regexp = "[^abc]{3}[A-Z0-9]{6}", message = "Regular expression error.")
    private String password;
    @NotBlank(message = "phoneNumber cannot be null or empty")
    private String phoneNumber;
    private Set<CardDto> cards;
    private Set<OrdersDto>orders;
    private Gender gender;
    private LocalDateTime birthdate;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
