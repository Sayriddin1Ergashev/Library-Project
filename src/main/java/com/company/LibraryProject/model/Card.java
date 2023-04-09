package com.company.LibraryProject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("card"))
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("card_id"))
    private Integer cardId;

    @Column(name = ("card_name"))
    private String cardName;

    @Column(name = ("card_number"))
    private Long cardNumber;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_At"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
