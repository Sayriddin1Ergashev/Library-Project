package com.company.LibraryProject.service.validation;


import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.repository.GoalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GoalsValidate {

    private final BookService booksService;

    public List<ErrorDto> validate(GoalsDto goalsDto) {

        List<ErrorDto> errors = new ArrayList<>();

        if (booksService.getBook(goalsDto.getBookId()).getData == null){
            errors.add(new ErrorDto("bookId", "Book is not found!"));
        }

        return errors;
    }
}
