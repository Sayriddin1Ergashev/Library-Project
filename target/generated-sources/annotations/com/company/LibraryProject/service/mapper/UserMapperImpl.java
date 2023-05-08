package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.OrdersDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.model.Orders;
import com.company.LibraryProject.model.User;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T16:04:46+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
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
        userDto.setOrders( user.getOrders().stream().map(ordersMapper::toDtoNotUserId).collect(Collectors.toSet()) );

        return userDto;
    }

    @Override
    public UserDto toDtoByNotCards(User user) {
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
