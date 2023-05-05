package com.company.LibraryProject.service.validation;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorValidation {

    public List<ErrorDto> validate(AuthorDto dto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (dto.getAge() < 18) {
            errors.add(new ErrorDto("Age", "Age<18"));
        }
        return errors;
    }

}
