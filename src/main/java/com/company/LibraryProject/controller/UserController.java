package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ("user"))
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseDto<UserDto> createUser(@RequestBody UserDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping("/get")
    public ResponseDto<UserDto> getUser(@RequestParam(value = ("id")) Integer userID) {
        return userService.getUser(userID);
    }

    @PutMapping("/update")
    public ResponseDto<UserDto> updateUser(@RequestBody UserDto dto, @RequestParam(value = ("id")) Integer userID) {
        return userService.updateUser(dto, userID);
    }

    @DeleteMapping("/delete")
    public ResponseDto<UserDto> deleteUser(@RequestParam(value = ("id")) Integer userID) {
        return userService.delete(userID);
    }

    @GetMapping(value = ("/get-all"))
    public ResponseDto<List<UserDto>> getAllUser() {
        return userService.getAll();
    }
    public void data(){
        //Hasanboy
        //Java Developer Backend
    }
}
