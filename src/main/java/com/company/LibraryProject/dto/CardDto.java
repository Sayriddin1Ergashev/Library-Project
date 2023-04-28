package com.company.LibraryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDto {
    private Integer cardId;
    @NotNull(message = "cardName cannot be null.")
    @NotEmpty(message = "cardName cannot be empty.")
    private String cardName;//|-> ""
    @NotBlank(message = "cardNumber cannot be null or empty.")//|-> ""
    private String cardNumber;
    @NotNull(message = "userId cannot be null.")
    private Integer userId;
    private ResponseUserDto userDto;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}



