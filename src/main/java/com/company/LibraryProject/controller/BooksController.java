package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.BooksService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BooksController {

    private final BooksService booksService;

    @PostMapping("/create")
    public ResponseDto<BooksDto> createBooks(@Valid @RequestBody BooksDto dto) {
        return booksService.createBooks(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<BooksDto> getBooks(@PathVariable("id") Integer booksId) {
        return booksService.getBooks(booksId);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<BooksDto> updateBooks(@RequestBody BooksDto dto, @PathVariable("id") Integer booksId) {
        return booksService.updateBooks(dto, booksId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<BooksDto> deleteBooks(@PathVariable("id") Integer booksId) {
        return booksService.deleteBooks(booksId);
    }


}
