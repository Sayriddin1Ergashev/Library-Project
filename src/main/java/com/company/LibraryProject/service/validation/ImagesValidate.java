package com.company.LibraryProject.service.validation;

import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ImagesDto;
import com.company.LibraryProject.repository.ImagesRepository;
import com.company.LibraryProject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ImagesValidate {
    private final ImagesRepository imagesRepository;
    private final BookService bookService;
    public List<ErrorDto> validate(ImagesDto imagesDto) {
        List<ErrorDto> errors = new ArrayList<>();
        if (bookService.getBook(imagesDto.getBooksId()).getData() == null){
            errors.add(new ErrorDto("bookId", "Book is not found!"));
        }
        if (imagesRepository.existsByTokenAndDeletedAtIsNull(imagesDto.getToken())){
            errors.add(new ErrorDto("Token","This token is already exist"));
        }
        return errors;
    }
}
