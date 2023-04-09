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
@Slf4j
@RequiredArgsConstructor
public class UserService {

    //DI -> Dependency Injection
    private final CardService cardService;
    private final CardMapper cardMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public ResponseDto<UserDto> createUser(UserDto dto) {

        try {
            User user = userMapper.toEntity(dto);
            if (user == null) {
                return ResponseDto.<UserDto>builder()
                        .code(-3)
                        .message("Possess Error")
                        .build();
            }
            user.setCreatedAt(LocalDateTime.now());
            userRepository.save(user);
            log.info(String.format("This is user %d id successful created!", user.getUserId()));
            return ResponseDto.<UserDto>builder()
                    .message("User successful created!")
                    .success(true)
                    .build();
        } catch (Exception e) {
            log.info(String.format("User while saving error :: %s", e.getMessage()));
            return ResponseDto.<UserDto>builder()
                    .code(-3)
                    .message(String.format("User while saving error :: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<UserDto> getUser(Integer userId) {
        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            log.warn(String.format("This user %d id is not found!", userId));
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message(String.format("This user %d id is not found!", userId))
                    .build();
        }
        return ResponseDto.<UserDto>builder()
                .message("OK")
                .success(true)
                .data(userMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<UserDto> updateUser(UserDto dto, Integer userId) {
        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            log.warn(String.format("This user %d id is not found!", userId));
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message(String.format("This user %d id is not found!", userId))
                    .build();
        }
        try {
            User user = userMapper.toEntity(dto);
            if (user == null){
                return null;
            }
            user.setUserId(optional.get().getUserId());
            user.setUpdatedAt(LocalDateTime.now());
            user.setCard(this.cardMapper.toEntity(cardService.get(dto.getCardId()).getData()));
            this.userRepository.save(user);
            log.info(String.format("This user %d id successful updated!", user.getUserId()));
            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.userMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            log.info(String.format("User while saving error :: %s", e.getMessage()));
            return ResponseDto.<UserDto>builder()
                    .code(-3)
                    .message(String.format("User while saving error :: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<UserDto> delete(Integer userId) {
        Optional<User> optional = userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            log.warn(String.format("This user %d id is not found!", userId));
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message(String.format("This user %d id is not found!", userId))
                    .build();
        }
        try {
            User user = optional.get();
            user.setDeletedAt(LocalDateTime.now());
            this.userRepository.save(user);
            log.info(String.format("This user %d id successful deleted!", user.getUserId()));
            return ResponseDto.<UserDto>builder()
                    .message("OK")
                    .success(true)
                    .data(userMapper.toDto(optional.get()))
                    .build();
        } catch (Exception e) {
            log.info(String.format("User while saving error :: %s", e.getMessage()));
            return ResponseDto.<UserDto>builder()
                    .code(-3)
                    .message(String.format("User while saving error :: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<List<UserDto>> getAll() {
        return ResponseDto.<List<UserDto>>builder()
                .success(true)
                .message("OK")
                .data(userRepository.findAll()
                        .stream()
                        .map(this.userMapper::toDto)
                        .toList())
                .build();
    }

    public ResponseDto<List<UserDto>> getAllUserTwo() {
        return null;
    }

}
