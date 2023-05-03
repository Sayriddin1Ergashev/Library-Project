package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.BooksService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BooksController {
    private final BooksService booksService;

    @PostMapping("/create")
    public ResponseDto<BooksDto> createBooks(@Valid @RequestBody BooksDto booksDto) {
        return this.booksService.create(booksDto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<BooksDto> getBooks(@PathVariable(value = "id") Integer id) {
        return this.booksService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<BooksDto> updateBooks(@PathVariable(value = "id") Integer id,@Valid @RequestBody BooksDto booksDto) {
        return this.booksService.update(id, booksDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<BooksDto> deleteBooks(@PathVariable(value = "id") Integer id) {
        return this.booksService.delete(id);
    }

    @GetMapping("/get-all")
    public ResponseDto<List<BooksDto>> getAllBooks() {
        return this.booksService.getAll();
    }
}
