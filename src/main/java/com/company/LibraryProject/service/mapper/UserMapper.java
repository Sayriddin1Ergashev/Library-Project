package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDto dto) {
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());
        user.setCardId(dto.getCardId());
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
