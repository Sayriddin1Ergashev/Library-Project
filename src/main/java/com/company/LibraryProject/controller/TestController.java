package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping(value = "/get")
    public ResponseDto<UserDto>getFirstUser(){
        return this.testService.getFirstUser();
    }
}
