package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.UserDto;
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

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract User toEntity(UserDto dto);

    @Mapping(target = "cards", expression = "java(user.getCards().stream().map(cardMapper::toDtoNotUserId).collect(Collectors.toSet()))")
    public abstract UserDto toDto(User user);

    public void viewMethod(){
        UserDto dto = new UserDto();
        User user = new User();
        Set<CardDto> cardDtoSet = user.getCards().stream().map(cardMapper::toDtoNotUserId).collect(Collectors.toSet());
        dto.setCards(cardDtoSet);
    }



}
