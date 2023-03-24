package com.company.LibraryProject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Card {
    private Integer cardId;
    private String cardName;
    private Long cardNumber;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
