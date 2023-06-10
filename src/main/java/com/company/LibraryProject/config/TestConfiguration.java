package com.company.LibraryProject.config;

import com.company.LibraryProject.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean(name = "first")
    public UserDto firstUser() {
        return UserDto.builder()
                .userId(1)
                .firstName("Elbik")
                .lastName("Rustamov")
                .email("qwerty@gmail.com")
                .build();
    }

    @Bean(name = "second")
    public UserDto secondUser() {
        return UserDto.builder()
                .userId(1)
                .firstName("Bobur")
                .lastName("Nuraliyev")
                .email("qwerty@gmail.com")
                .build();
    }
}
