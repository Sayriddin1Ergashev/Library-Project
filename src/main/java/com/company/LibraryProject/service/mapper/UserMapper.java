package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseCardDto;
import com.company.LibraryProject.dto.ResponseUserDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.model.User;
import com.company.LibraryProject.service.CardService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class})
public abstract class UserMapper {
    @Lazy
    @Autowired
    protected CardService cardService;

    @Lazy
    @Autowired
    protected CardMapper cardMapper;

    @Mapping(target = "cards", expression = "java(cardService.getAllCardsByUserId(user.getUserId())" +
            ".getData()" +
            ".stream()" +
            ".map(cardMapper::toEntityByNotUser)" +
            ".collect(Collectors.toSet()))")
    public abstract UserDto toDto(User user);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
   /* @Mapping(target = "cards", expression = "java(dto.getCards().stream()" +
            ".map(cardMapper::toEntity).collect(Collectors.toSet()))")*/
    public abstract User toEntity(UserDto dto);

    public abstract ResponseUserDto toDtoByNotCard(UserDto user);


}
