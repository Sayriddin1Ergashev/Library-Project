package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CardMapper {

    @Autowired
    protected UserService userService;
    @Autowired
    protected UserMapper userMapper;

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Card toEntity(CardDto dto);

    public abstract CardDto toDto(Card card);

    @Mapping(target = "userId", ignore = true)
    public abstract CardDto toDtoNotUserId(Card card);




}
