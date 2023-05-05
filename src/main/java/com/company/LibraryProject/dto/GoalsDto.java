package com.company.LibraryProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GoalsDto {
    private Integer goalsId;
    @NotBlank(message = "language cannot be null or empty.")
    private String language;
    private String description;

    @NotNull(message = "bookId cannot be null.")
    private Integer bookId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
