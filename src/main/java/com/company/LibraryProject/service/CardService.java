package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Card;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private List<Card> cardList;
    private Integer index;

    public CardService() {
        this.cardList = new ArrayList<>();
        this.index = 0;
    }

    public ResponseDto<CardDto> create(CardDto dto) {
        if (dto.getCardNumber().toString().length() != 16) {
            return ResponseDto.<CardDto>builder()
                    .message("Card code error")
                    .success(false)
                    .data(dto)
                    .build();
        }

        Card card = toEntity(dto);
        card.setCardId(++this.index);
        card.setCreatedAt(LocalDateTime.now());
        this.cardList.add(card);

        return ResponseDto.<CardDto>builder()
                .message("OK")
                .success(true)
                .data(toDto(card))
                .build();
    }

    public ResponseDto<CardDto> get(Integer cardId) {
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)) {
                return ResponseDto.<CardDto>builder()
                        .message("OK")
                        .success(true)
                        .data(toDto(card))
                        .build();
            }
        }
        return ResponseDto.<CardDto>builder()
                .code(-1)
                .message("Card is not found!")
                .build();
    }

    public ResponseDto<CardDto> update(CardDto dto, Integer cardId) {
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)) {
                card = toEntity(dto);
                card.setUpdatedAt(LocalDateTime.now());
                this.cardList.add(card);
                return ResponseDto.<CardDto>builder()
                        .message("OK")
                        .data(toDto(card))
                        .success(true)
                        .build();
            }
        }
        return ResponseDto.<CardDto>builder()
                .code(-1)
                .message("Card is not found!")
                .build();
    }

    public ResponseDto<CardDto> delete(Integer cardId) {
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)) {
                this.cardList.remove(card);
                return ResponseDto.<CardDto>builder()
                        .success(true)
                        .message("OK")
                        .data(toDto(card))
                        .build();
            }
        }
        return ResponseDto.<CardDto>builder()
                .code(-1)
                .message("Card is not found!")
                .build();
    }

    private Card toEntity(CardDto dto) {
        Card card = new Card();
        card.setCardName(dto.getCardName());
        card.setCardNumber(dto.getCardNumber());
        return card;
    }

    private CardDto toDto(Card card) {
        CardDto dto = new CardDto();
        dto.setCardId(card.getCardId());
        dto.setCardName(card.getCardName());
        dto.setCardNumber(card.getCardNumber());
        dto.setCreatedAt(card.getCreatedAt());
        dto.setUpdatedAt(card.getUpdatedAt());
        return dto;
    }

}
