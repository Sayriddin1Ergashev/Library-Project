package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class})
public abstract class UserMapper {


    @Lazy
    @Autowired
    protected CardMapper cardMapper;
    @Lazy
    @Autowired
    protected OrdersMapper ordersMapper;
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract User toEntity(UserDto dto);

    @Mapping(target = "cards", expression = "java(user.getCards().stream().map(cardMapper::toDtoNotUserId).collect(Collectors.toSet()))")
    @Mapping(target = "orders", expression = "java(user.getOrders().stream().map(ordersMapper::toDtoNotUserId).collect(Collectors.toSet()))")
    public abstract UserDto toDto(User user);
    @Mapping(target = "cards",ignore = true)
    @Mapping(target = "orders",ignore = true)
    public abstract UserDto toDtoByNotCards(User user);





}
