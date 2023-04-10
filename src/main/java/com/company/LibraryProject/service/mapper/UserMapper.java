package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.User;
import com.company.LibraryProject.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final CardMapper cardMapper;
    private final CardService cardService;

    public User toEntity(UserDto dto){
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setBirthdate(dto.getBirthdate());
        user.setCardId(dto.getCardId());
        user.setCard(cardMapper.toEntity(cardService.getCard(dto.getCardId()).getData()));
        user.setCreatedAt(dto.getCreatedAt());
        user.setUpdatedAt(dto.getUpdatedAt());
        user.setDeletedAt(dto.getDeletedAt());
        return user;
    }

    public UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setBirthdate(user.getBirthdate());
        dto.setCardId(user.getCardId());
        dto.setCard(user.getCard());
        dto.setGender(user.getGender());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setDeletedAt(user.getDeletedAt());
        return dto;
    }
}
