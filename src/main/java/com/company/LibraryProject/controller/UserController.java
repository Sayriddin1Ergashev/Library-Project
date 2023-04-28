package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = ("/create"))
    public ResponseDto<UserDto> createUser(@Valid @RequestBody UserDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping(value = ("/get/{id}"))
    public ResponseDto<UserDto> getUser(@PathVariable("id") Integer userId) {
        return userService.getUser(userId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<UserDto> updateUser(@PathVariable("id") Integer userId,
                                           @Valid @RequestBody UserDto dto) {
        return userService.updateUser(dto, userId);
    }

    @DeleteMapping(value = ("/delete/{id}"))
    public ResponseDto<UserDto> deleteUser(@PathVariable("id") Integer userId) {
        return userService.deleteUser(userId);
    }
}
