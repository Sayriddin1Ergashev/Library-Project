package com.company.LibraryProject.service;


import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.model.User;
import com.company.LibraryProject.repository.UserRepository;
import com.company.LibraryProject.service.mapper.CardMapper;
import com.company.LibraryProject.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public ResponseDto<UserDto> createUser(UserDto dto) {
        if (cardService.getCard(dto.getCardId()).getData() == null) {
            return ResponseDto.<UserDto>builder()
                    .message("Card is not found!")
                    .code(-3)
                    .build();
        }
        try {

            User user = userMapper.toEntity(dto);
            user.setCreatedAt(LocalDateTime.now());

            userRepository.save(user);
            log.info(String.format("Created user by id %d successfully!", user.getUserId()));
            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("User successful created!")
                    .data(userMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            log.warn(String.format("User while saving error :: %s", e.getMessage()));
            return ResponseDto.<UserDto>builder()
                    .message("User while saving error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<UserDto> getUser(Integer userId) {
        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<UserDto>builder()
                .success(true)
                .message("OK")
                .data(userMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<UserDto> updateUser(UserDto dto, Integer userId) {

        if (cardService.getCard(dto.getCardId()).getData() == null) {
            return ResponseDto.<UserDto>builder()
                    .message("Card is not found!")
                    .code(-3)
                    .build();
        }

        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .build();
        }

        try {

            User user = userMapper.toEntity(dto);
            user.setUserId(optional.get().getUserId());
            user.setCreatedAt(optional.get().getCreatedAt());
            user.setDeletedAt(optional.get().getDeletedAt());
            user.setUpdatedAt(LocalDateTime.now());
            userRepository.save(user);
            log.info("User successful updated!");

            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("OK")
                    .data(userMapper.toDto(user))
                    .build();

        } catch (Exception e) {
            log.warn(String.format("User while saving error :: %s", e.getMessage()));
            return ResponseDto.<UserDto>builder()
                    .message("User while saving error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<UserDto> deleteUser(Integer userId) {
        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .build();
        }
        try {
            User user = optional.get();
            user.setDeletedAt(LocalDateTime.now());
            userRepository.save(user);
            log.info("User successful deleted!");
            return ResponseDto.<UserDto>builder()
                    .message("OK")
                    .success(true)
                    .data(userMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            log.warn(String.format("User while saving error :: %s", e.getMessage()));
            return ResponseDto.<UserDto>builder()
                    .message("User while saving error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<List<UserDto>> getAll() {
        List<UserDto> userList = userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
        if (userList.isEmpty()) {
            return ResponseDto.<List<UserDto>>builder()
                    .message("Users is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<List<UserDto>>builder()
                .success(true)
                .message("OK")
                .data(userList)
                .build();
    }
}
