package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.User;
import com.company.LibraryProject.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserMapper {

    private final CardService cardService;
    private final CardMapper cardMapper;

    public User toEntity(UserDto dto) {
        if (cardService.get(dto.getCardId()).getData() == null) {
            log.warn(String.format("This card %d id is not found!", dto.getCardId()));
            return null;
        }
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());
        user.setCardId(dto.getCardId());
        user.setCard(this.cardMapper.toEntity(cardService.get(dto.getCardId()).getData()));
        user.setGender(dto.getGender());
        user.setBirthdate(dto.getBirthdate());
        return user;
    }

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setLastname(user.getLastname());
        dto.setEmail(user.getEmail());
        dto.setFirstname(user.getFirstname());
        dto.setPassword(user.getPassword());
        dto.setAge(user.getAge());
        dto.setCardId(user.getCardId());
        dto.setCard(user.getCard());
        dto.setGender(user.getGender());
        dto.setBirthdate(user.getBirthdate());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }
}
