package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("cards"))
public class Card {
    @Id
    @Column(name = ("card_id"))
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private String cardName;

    private String cardNumber;

    private Integer userId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;



}
