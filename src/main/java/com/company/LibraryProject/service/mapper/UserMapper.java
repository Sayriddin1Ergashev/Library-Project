package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, PasswordEncoder.class})
public abstract class UserMapper {


    @Lazy
    @Autowired
    protected CardMapper cardMapper;
    @Lazy
    @Autowired
    protected OrdersMapper ordersMapper;

    @Autowired
    protected PasswordEncoder passwordEncoder;
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "password",expression = "java(passwordEncoder" +
            ".encode(dto.passwordEncoder))")
    public abstract User toEntity(UserDto dto);
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "updatedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "deletedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "cards", expression = "java(user.getCards().stream()." +
            "map(cardMapper::toDtoNotUserId).collect(Collectors.toSet()))")
    @Mapping(target = "orders", expression = "java(user.getOrders().stream()." +
            "map(ordersMapper::toDtoNotUserId).collect(Collectors.toSet()))")
    public abstract UserDto toDto(User user);
    @Mapping(target = "cards",ignore = true)
    @Mapping(target = "orders",ignore = true)
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "updatedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "deletedAt", dateFormat = "yyyy-MM-dd")
    public abstract UserDto toDtoByNotCards(User user);

@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget User user, UserDto dto);
}
