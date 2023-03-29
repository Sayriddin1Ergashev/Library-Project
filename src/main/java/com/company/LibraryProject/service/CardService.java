package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.service.mapper.CardMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private volatile List<Card> cardList;
    private Integer index;

    private CardMapper cardMapper;

    //DI -> Dependency Injection
    public CardService(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
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

        Card card = cardMapper.toEntity(dto);
        card.setCardId(++this.index);
        card.setCreatedAt(LocalDateTime.now());
        this.cardList.add(card);

        return ResponseDto.<CardDto>builder()
                .message("OK")
                .success(true)
                .data(cardMapper.toDto(card))
                .build();
    }

    public ResponseDto<CardDto> get(Integer cardId) {
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)) {
                return ResponseDto.<CardDto>builder()
                        .message("OK")
                        .success(true)
                        .data(cardMapper.toDto(card))
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
                card = cardMapper.toEntity(dto);
                card.setUpdatedAt(LocalDateTime.now());
                this.cardList.add(card);
                return ResponseDto.<CardDto>builder()
                        .message("OK")
                        .data(cardMapper.toDto(card))
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
                        .data(cardMapper.toDto(card))
                        .build();
            }
        }
        return ResponseDto.<CardDto>builder()
                .code(-1)
                .message("Card is not found!")
                .build();
    }
}
