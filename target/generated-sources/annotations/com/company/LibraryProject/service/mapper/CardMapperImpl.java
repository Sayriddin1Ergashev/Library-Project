package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.model.Card;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T16:04:47+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class CardMapperImpl extends CardMapper {

    @Override
    public Card toEntity(CardDto dto) {
        if ( dto == null ) {
            return null;
        }

        Card card = new Card();

        card.setCardId( dto.getCardId() );
        card.setCardName( dto.getCardName() );
        card.setCardNumber( dto.getCardNumber() );
        card.setUserId( dto.getUserId() );

        return card;
    }

    @Override
    public CardDto toDto(Card card) {
        if ( card == null ) {
            return null;
        }

        CardDto cardDto = new CardDto();

        cardDto.setCardId( card.getCardId() );
        cardDto.setCardName( card.getCardName() );
        cardDto.setCardNumber( card.getCardNumber() );
        cardDto.setUserId( card.getUserId() );
        cardDto.setCreatedAt( card.getCreatedAt() );
        cardDto.setUpdatedAt( card.getUpdatedAt() );
        cardDto.setDeletedAt( card.getDeletedAt() );

        return cardDto;
    }

    @Override
    public CardDto toDtoNotUserId(Card card) {
        if ( card == null ) {
            return null;
        }

        CardDto cardDto = new CardDto();

        cardDto.setCardId( card.getCardId() );
        cardDto.setCardName( card.getCardName() );
        cardDto.setCardNumber( card.getCardNumber() );
        cardDto.setCreatedAt( card.getCreatedAt() );
        cardDto.setUpdatedAt( card.getUpdatedAt() );
        cardDto.setDeletedAt( card.getDeletedAt() );

        return cardDto;
    }
}
