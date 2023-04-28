package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ResponseCardDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.repository.CardRepository;
import com.company.LibraryProject.service.mapper.CardMapper;
import com.company.LibraryProject.service.validation.CardValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardMapper cardMapper;

    private final CardRepository cardRepository;

    private final CardValidate cardValidate;

    public ResponseDto<CardDto> createCard(CardDto dto) {

        List<ErrorDto> errors = cardValidate.validate(dto);
        if (!errors.isEmpty()){
            return ResponseDto.<CardDto>builder()
                    .message("Validation error")
                    .code(-2)
                    .data(dto)
                    .errors(errors)
                    .build();
        }

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
                    .code(-3)
                    .message("Card while saving error: " + c.getMessage())
                    .build();

        }
    }

    public ResponseDto<CardDto> getCard(Integer cardId) {
        try {
            Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(cardId);
            if (optional.isEmpty()) {
                return ResponseDto.<CardDto>builder()
                        .message("Card is not found!")
                        .code(-1)
                        .build();
            }


            return ResponseDto.<CardDto>builder()
                    .message("OK")
                    .success(true)
                    .data(cardMapper.toDto(optional.get()))
                    .build();
        } catch (Exception c) {
            return ResponseDto.<CardDto>builder()
                    .code(-3)
                    .message("Database Error: " + c.getMessage())
                    .data(null)
                    .build();
        }
    }

    public ResponseDto<CardDto> updateCard(CardDto dto, Integer id) {
        List<ErrorDto> errors = cardValidate.validate(dto);
        if (!errors.isEmpty()){
            return ResponseDto.<CardDto>builder()
                    .message("Validation error")
                    .code(-2)
                    .data(dto)
                    .errors(errors)
                    .build();
        }

        Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
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
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<CardDto> deleteCard(Integer id) {
        Optional<Card> optional = cardRepository.findByCardIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
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
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<List<ResponseCardDto>> getAllCardsByUserId(Integer userId) {
        return ResponseDto.<List<ResponseCardDto>>builder()
                .success(true)
                .message("OK")
                .data(cardRepository.findAllByUserIdAndDeletedAtIsNull(userId)
                        .stream()
                        .map(cardMapper::toDtoByNotUser)
                        .toList())
                .build();
    }


}