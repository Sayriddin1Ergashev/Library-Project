package com.company.LibraryProject.service;


import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> userList;
    private Integer userIndex;
    private CardService cardService;

    public UserService(CardService cardService) {
        this.cardService = cardService;
        this.userList = new ArrayList<>();
        this.userIndex = 0;
    }

    public ResponseDto<UserDto> createUser(UserDto dto) {
        CardDto cardDto = this.cardService.get(dto.getCardId()).getData();
        if (cardDto == null) {
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message("Card is not found!")
                    .build();
        }

        User user = toEntity(dto);
        user.setUserId(++this.userIndex);
        user.setCreatedAt(LocalDateTime.now());
        this.userList.add(user);

        return ResponseDto.<UserDto>builder()
                .message("User successful created!")
                .success(true)
                .build();
    }

    public ResponseDto<UserDto> getUser(Integer userID) {
        for (User user : this.userList) {
            if (user.getUserId().equals(userID)) {
                UserDto dto = toDto(user);
                return ResponseDto.<UserDto>builder()
                        .message("OK")
                        .success(true)
                        .data(dto)
                        .build();
            }
        }
        return ResponseDto.<UserDto>builder()
                .message("User is not found!")
                .success(false)
                .build();
    }

    public ResponseDto<UserDto> updateUser(UserDto dto, Integer userID) {
        CardDto cardDto = this.cardService.get(dto.getCardId()).getData();
        if (cardDto == null) {
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message("Card is not found!")
                    .build();
        }

        for (User user : this.userList) {
            if (user.getUserId().equals(userID)) {
                user = toEntity(dto);
                user.setUpdatedAt(LocalDateTime.now());
                this.userList.add(user);
                return ResponseDto.<UserDto>builder()
                        .message("User successful updated!")
                        .success(true)
                        .build();
            }
        }
        return ResponseDto.<UserDto>builder()
                .message("User is not found!")
                .success(false)
                .build();
    }

    public ResponseDto<UserDto> delete(Integer userID) {
        for (User user : this.userList) {
            if (user.getUserId().equals(userID)) {
                this.userList.remove(user);
                return ResponseDto.<UserDto>builder()
                        .success(true)
                        .message("OK")
                        .build();
            }
        }
        return ResponseDto.<UserDto>builder()
                .message("User is not found!")
                .success(false)
                .build();
    }

    public ResponseDto<List<UserDto>> getAll() {
        return ResponseDto.<List<UserDto>>builder()
                .message("OK")
                .data(this.userList
                        .stream()
                        .map(this::toDto)
                        .toList()
                )
                .build();
    }

    //18 katta bo`lgan barcha userlarni olib keling.
    public ResponseDto<List<UserDto>> getAgeUser() {
        List<UserDto> userDtoList = this.userList.stream()
                .filter(age -> {
                    if (age.getAge() > 18) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .map(this::toDto)
                .toList();
        return ResponseDto.<List<UserDto>>builder()
                .message("OK")
                .success(true)
                .data(userDtoList)
                .build();
    }

    private User toEntity(UserDto dto) {
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());
        user.setCardId(dto.getCardId());
        user.setCard(dto.getCard());
        user.setGender(dto.getGender());
        user.setBirthdate(dto.getBirthdate());
        return user;
    }

    private UserDto toDto(User user) {
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
