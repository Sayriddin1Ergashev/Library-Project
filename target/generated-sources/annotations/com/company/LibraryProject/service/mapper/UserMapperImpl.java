package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.OrdersDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.model.Orders;
import com.company.LibraryProject.model.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T20:14:00+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class UserMapperImpl extends UserMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

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
        user.setOrders( ordersDtoSetToOrdersSet( dto.getOrders() ) );
        user.setGender( dto.getGender() );

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( user.getCreatedAt() != null ) {
            userDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getCreatedAt() ) );
        }
        if ( user.getUpdatedAt() != null ) {
            userDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getUpdatedAt() ) );
        }
        if ( user.getDeletedAt() != null ) {
            userDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getDeletedAt() ) );
        }
        userDto.setUserId( user.getUserId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setGender( user.getGender() );
        userDto.setBirthdate( user.getBirthdate() );

        userDto.setCards( user.getCards().stream().map(cardMapper::toDtoNotUserId).collect(Collectors.toSet()) );
        userDto.setOrders( user.getOrders().stream().map(ordersMapper::toDtoNotUserId).collect(Collectors.toSet()) );

        return userDto;
    }

    @Override
    public UserDto toDtoByNotCards(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( user.getCreatedAt() != null ) {
            userDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getCreatedAt() ) );
        }
        if ( user.getUpdatedAt() != null ) {
            userDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getUpdatedAt() ) );
        }
        if ( user.getDeletedAt() != null ) {
            userDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( user.getDeletedAt() ) );
        }
        userDto.setUserId( user.getUserId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setGender( user.getGender() );
        userDto.setBirthdate( user.getBirthdate() );

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
        if ( cardDto.getCreatedAt() != null ) {
            card.setCreatedAt( LocalDateTime.parse( cardDto.getCreatedAt() ) );
        }
        if ( cardDto.getUpdatedAt() != null ) {
            card.setUpdatedAt( LocalDateTime.parse( cardDto.getUpdatedAt() ) );
        }
        if ( cardDto.getDeletedAt() != null ) {
            card.setDeletedAt( LocalDateTime.parse( cardDto.getDeletedAt() ) );
        }

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

    protected Orders ordersDtoToOrders(OrdersDto ordersDto) {
        if ( ordersDto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setOrdersId( ordersDto.getOrdersId() );
        orders.setUserId( ordersDto.getUserId() );
        orders.setTotal( ordersDto.getTotal() );
        if ( ordersDto.getCreatedAt() != null ) {
            orders.setCreatedAt( LocalDateTime.parse( ordersDto.getCreatedAt() ) );
        }
        if ( ordersDto.getUpdatedAt() != null ) {
            orders.setUpdatedAt( LocalDateTime.parse( ordersDto.getUpdatedAt() ) );
        }
        if ( ordersDto.getDeletedAt() != null ) {
            orders.setDeletedAt( LocalDateTime.parse( ordersDto.getDeletedAt() ) );
        }

        return orders;
    }

    protected Set<Orders> ordersDtoSetToOrdersSet(Set<OrdersDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Orders> set1 = new LinkedHashSet<Orders>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrdersDto ordersDto : set ) {
            set1.add( ordersDtoToOrders( ordersDto ) );
        }

        return set1;
    }
}
