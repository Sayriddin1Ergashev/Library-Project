package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardMapper {

    private final UserService userService;

    private final UserMapper userMapper;

    public Card toEntity(CardDto dto) {
        Card card = new Card();
        card.setCardId(dto.getCardId());
        card.setUserId(dto.getUserId());
        card.setCardNumber(dto.getCardNumber());
        card.setCardName(dto.getCardName());
        return card;
    }

    public CardDto toDto(Card card) {
        CardDto dto = new CardDto();
        dto.setCardId(card.getCardId());
        dto.setCardNumber(card.getCardNumber());
        dto.setCardName(card.getCardName());
        dto.setUserDto(userMapper.userDtoNotCard(card.getUsers()));
        dto.setCreatedAt(card.getCreatedAt());
        dto.setUpdatedAt(card.getUpdatedAt());
        dto.setDeletedAt(card.getDeletedAt());
        return dto;
    }

}
