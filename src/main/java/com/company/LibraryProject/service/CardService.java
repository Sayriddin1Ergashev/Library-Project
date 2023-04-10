package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.repository.CardRepository;
import com.company.LibraryProject.service.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    private final CardMapper cardMapper;

    public ResponseDto<CardDto> createCard(CardDto dto) {
        try {
            Card card = cardMapper.toEntity(dto);
            card.setCreatedAt(LocalDateTime.now());
            cardRepository.save(card);

            return ResponseDto.<CardDto>builder()
                    .message("OK")
                    .success(true)
                    .data(cardMapper.toDto(card))
                    .build();

        } catch (Exception c) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
                    .message("Database Error: " + c.getMessage())
                    .build();

        }
    }

    public ResponseDto<CardDto> getCard(Integer card_id) {
        try {
            Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(card_id);
            if (optional.isEmpty()) {
                return ResponseDto.<CardDto>builder()
                        .message("Product is not found")
                        .code(-3)
                        .build();
            }
            return ResponseDto.<CardDto>builder()
                    .message("OK")
                    .success(true)
                    .data(cardMapper.toDto(optional.get()))
                    .build();

        } catch (Exception c) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
                    .message("Database Error: " + c.getMessage())
                    .build();
        }

    }

    public ResponseDto<CardDto> updateCard(CardDto dto, Integer id) {
        Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-3)
                    .message("Card is not found!")
                    .build();
        }
        try {
            Card card = cardMapper.toEntity(dto);
            card.setCardId(optional.get().getCardId());
            card.setCreatedAt(optional.get().getCreatedAt());
            card.setDeletedAt(optional.get().getDeletedAt());
            card.setUpdatedAt(LocalDateTime.now());
            cardRepository.save(card);
            return ResponseDto.<CardDto>builder()
                    .message("OK")
                    .success(true)
                    .data(cardMapper.toDto(card))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CardDto>builder()
                    .message("Card while saving error :: {}" + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<CardDto> deleteCard(Integer id) {
        Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-3)
                    .message("Card is not found!")
                    .build();
        }
        try {
            Card card = optional.get();
            card.setDeletedAt(LocalDateTime.now());
            cardRepository.save(card);
            return ResponseDto.<CardDto>builder()
                    .success(true)
                    .message("OK")
                    .data(cardMapper.toDto(card))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CardDto>builder()
                    .message("Card while saving error :: {}" + e.getMessage())
                    .code(-1)
                    .build();
        }
    }
}