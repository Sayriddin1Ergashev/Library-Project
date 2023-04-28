package com.company.LibraryProject.service.validation;

import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.UserDto;
import com.company.LibraryProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserValidate {

    private final UserRepository userRepository;

    public List<ErrorDto> validate(UserDto dto) {
        List<ErrorDto> errorDtoList = new ArrayList<>();
        if (dto.getFirstName() == null) {
            errorDtoList.add(new ErrorDto("firstname", "Firstname cannot be empty"));
        }
        if (dto.getLastName() == null) {
            errorDtoList.add(new ErrorDto("lastname", "Lastname cannot be empty"));
        }
        if (dto.getEmail() == null) {
            errorDtoList.add(new ErrorDto("email", "Email cannot be empty"));
        } else if (userRepository.existsByEmail(dto.getEmail())) {
            errorDtoList.add(new ErrorDto("email", "Email is already exist"));
        }
        if (dto.getPassword() == null) {
            errorDtoList.add(new ErrorDto("password", "Password cannot be empty"));
        }
        if (dto.getPhoneNumber() == null) {
            errorDtoList.add(new ErrorDto("phoneNumber", "Phone Number cannot be empty"));
        }
        return errorDtoList;
    }
}
