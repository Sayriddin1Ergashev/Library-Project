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

    @Column(name = ("card_name"))
    private String cardName;

    @Column(name = ("card_number"))
    private String cardNumber;

    @Column(name = ("created_At"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_At"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_At"))
    private LocalDateTime deletedAt;


}
