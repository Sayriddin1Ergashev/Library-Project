package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.model.Card;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T20:14:00+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class CardMapperImpl extends CardMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

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

        if ( card.getCreatedAt() != null ) {
            cardDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( card.getCreatedAt() ) );
        }
        if ( card.getUpdatedAt() != null ) {
            cardDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( card.getUpdatedAt() ) );
        }
        if ( card.getDeletedAt() != null ) {
            cardDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( card.getDeletedAt() ) );
        }
        cardDto.setCardId( card.getCardId() );
        cardDto.setCardName( card.getCardName() );
        cardDto.setCardNumber( card.getCardNumber() );

        cardDto.setUserDto( userMapper.toDtoByNotCards(userRepository.findByUserIdAndDeletedAtIsNull(card.getUserId()).get()) );

        return cardDto;
    }

    @Override
    public CardDto toDtoNotUserId(Card card) {
        if ( card == null ) {
            return null;
        }

        CardDto cardDto = new CardDto();

        if ( card.getCreatedAt() != null ) {
            cardDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( card.getCreatedAt() ) );
        }
        if ( card.getUpdatedAt() != null ) {
            cardDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( card.getUpdatedAt() ) );
        }
        if ( card.getDeletedAt() != null ) {
            cardDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( card.getDeletedAt() ) );
        }
        cardDto.setCardId( card.getCardId() );
        cardDto.setCardName( card.getCardName() );
        cardDto.setCardNumber( card.getCardNumber() );
        cardDto.setUserId( card.getUserId() );

        return cardDto;
    }
}
