package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.model.User;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T18:54:19+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( dto.getUserId() );
        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setPhoneNumber( dto.getPhoneNumber() );
        user.setBirthdate( dto.getBirthdate() );
        user.setCards( cardDtoSetToCardSet( dto.getCards() ) );
        user.setGender( dto.getGender() );

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId( user.getUserId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setGender( user.getGender() );
        userDto.setBirthdate( user.getBirthdate() );
        userDto.setCreatedAt( user.getCreatedAt() );
        userDto.setUpdatedAt( user.getUpdatedAt() );
        userDto.setDeletedAt( user.getDeletedAt() );

        userDto.setCards( user.getCards().stream().map(cardMapper::toDtoNotUserId).collect(Collectors.toSet()) );

        return userDto;
    }

    @Override
    public UserDto toDtoNotId(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId( user.getUserId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setCards( cardSetToCardDtoSet( user.getCards() ) );
        userDto.setGender( user.getGender() );
        userDto.setBirthdate( user.getBirthdate() );
        userDto.setCreatedAt( user.getCreatedAt() );
        userDto.setUpdatedAt( user.getUpdatedAt() );
        userDto.setDeletedAt( user.getDeletedAt() );

        return userDto;
    }

    protected Card cardDtoToCard(CardDto cardDto) {
        if ( cardDto == null ) {
            return null;
        }

        Card card = new Card();

        card.setCardId( cardDto.getCardId() );
        card.setCardName( cardDto.getCardName() );
        card.setCardNumber( cardDto.getCardNumber() );
        card.setUserId( cardDto.getUserId() );
        card.setCreatedAt( cardDto.getCreatedAt() );
        card.setUpdatedAt( cardDto.getUpdatedAt() );
        card.setDeletedAt( cardDto.getDeletedAt() );

        return card;
    }

    protected Set<Card> cardDtoSetToCardSet(Set<CardDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Card> set1 = new LinkedHashSet<Card>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CardDto cardDto : set ) {
            set1.add( cardDtoToCard( cardDto ) );
        }

        return set1;
    }

    protected CardDto cardToCardDto(Card card) {
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

    protected Set<CardDto> cardSetToCardDtoSet(Set<Card> set) {
        if ( set == null ) {
            return null;
        }

        Set<CardDto> set1 = new LinkedHashSet<CardDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Card card : set ) {
            set1.add( cardToCardDto( card ) );
        }

        return set1;
    }
}
