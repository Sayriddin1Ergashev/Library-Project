package com.company.LibraryProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CardDto {
    private Integer cardId;
    private String cardName;
    private Long cardNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
