package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    public Card toEntity(CardDto dto) {
        Card card = new Card();
        card.setCardName(dto.getCardName());
        card.setCardNumber(dto.getCardNumber());
        return card;
    }

    public CardDto toDto(Card card) {
        CardDto dto = new CardDto();
        dto.setCardId(card.getCardId());
        dto.setCardName(card.getCardName());
        dto.setCardNumber(card.getCardNumber());
        dto.setCreatedAt(card.getCreatedAt());
        dto.setUpdatedAt(card.getUpdatedAt());
        return dto;
    }
}
