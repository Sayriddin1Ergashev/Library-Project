package com.company.LibraryProject.dto;

import com.company.LibraryProject.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class ResponseCardDto {
    private Integer cardId;
    private String cardName;
    private String cardNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
