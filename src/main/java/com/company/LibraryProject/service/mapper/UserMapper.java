package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.User;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {

    public User toEntity(UserDto dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setLastName(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstname());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setBirthdate(dto.getBirthdate());
        user.setCreatedAt(dto.getCreatedAt());
        user.setUpdatedAt(dto.getUpdatedAt());
        user.setDeletedAt(dto.getDeletedAt());
        return user;
    }


    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setFirstname(user.getFirstName());
        dto.setLastname(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setBirthdate(user.getBirthdate());
        dto.setGender(user.getGender());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setDeletedAt(user.getDeletedAt());
        return dto;
    }

}
