package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.model.User;
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

    public ResponseDto<CardDto> create(CardDto dto) {
        try {
            Card card = cardMapper.toEntity(dto);
            card.setCreatedAt(LocalDateTime.now());
            cardRepository.save(card);
            return ResponseDto.<CardDto>builder()
                    .message("OK")
                    .success(true)
                    .data(cardMapper.toDto(card))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CardDto>builder()
                    .message(String.format("Card while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<CardDto> get(Integer cardId) {
        //select * from card where id = card_id and deleted_at is null;
        Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(cardId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
                    .message("Card is not found!")
                    .build();
        }

        return ResponseDto.<CardDto>builder()
                .message("OK")
                .success(true)
                .data(cardMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<CardDto> update(CardDto dto, Integer cardId) {
        Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(cardId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
                    .message("Card is not found!")
                    .build();
        }
        try {
            Card card = cardMapper.toEntity(dto);
            card.setCardId(optional.get().getCardId());
            card.setUpdatedAt(LocalDateTime.now());
            this.cardRepository.save(card);

            return ResponseDto.<CardDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.cardMapper.toDto(card))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CardDto>builder()
                    .message(String.format("Card while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<CardDto> delete(Integer cardId) {
        Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(cardId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .message("Card is not found!")
                    .code(-1)
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
                    .message(String.format("Card while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }
}
