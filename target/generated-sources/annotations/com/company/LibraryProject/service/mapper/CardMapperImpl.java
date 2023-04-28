package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseCardDto;
import com.company.LibraryProject.model.Card;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T19:47:19+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
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

        cardDto.setUserDto( userMapper.toDtoByNotCard(userService.getUser(cardDto.getUserId()).getData()) );

        return cardDto;
    }

    @Override
    public ResponseCardDto toDtoByNotUser(Card card) {
        if ( card == null ) {
            return null;
        }

        ResponseCardDto responseCardDto = new ResponseCardDto();

        responseCardDto.setCardId( card.getCardId() );
        responseCardDto.setCardName( card.getCardName() );
        responseCardDto.setCardNumber( card.getCardNumber() );
        responseCardDto.setCreatedAt( card.getCreatedAt() );
        responseCardDto.setUpdatedAt( card.getUpdatedAt() );
        responseCardDto.setDeletedAt( card.getDeletedAt() );

        return responseCardDto;
    }

    @Override
    public CardDto toEntityByNotUser(ResponseCardDto dto) {
        if ( dto == null ) {
            return null;
        }

        CardDto cardDto = new CardDto();

        cardDto.setCardId( dto.getCardId() );
        cardDto.setCardName( dto.getCardName() );
        cardDto.setCardNumber( dto.getCardNumber() );
        cardDto.setCreatedAt( dto.getCreatedAt() );
        cardDto.setUpdatedAt( dto.getUpdatedAt() );
        cardDto.setDeletedAt( dto.getDeletedAt() );

        return cardDto;
    }
}
