package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.AuthorService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/create")
    public ResponseDto<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto dto) {
        return authorService.createAuthor(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<AuthorDto> getAuthor(@PathVariable Integer id) {
        return authorService.getAuthor(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<AuthorDto> updateAuthor(@Valid @RequestBody AuthorDto dto, @PathVariable Integer id) {
        return authorService.updateAuthor(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<AuthorDto> deleteAuthor(@PathVariable Integer id) {
        return authorService.deleteAuthor(id);
    }
}
