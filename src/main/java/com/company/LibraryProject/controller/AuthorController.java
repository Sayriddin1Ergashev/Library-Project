package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;
    @PostMapping("/create")
    public ResponseDto<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto authorDto) {
        return this.authorService.create(authorDto);
    }
    @GetMapping("/get/{id}")
    public ResponseDto<AuthorDto> getAuthor(@PathVariable(value = "id") Integer id) {
        return this.authorService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<AuthorDto> updateAuthor(@Valid @RequestBody AuthorDto authorDto, @PathVariable(value = "id") Integer id) {
        return this.authorService.update(id, authorDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<AuthorDto> deleteAuthor(@PathVariable(value = "id") Integer id) {
        return this.authorService.delete(id);
    }

    @GetMapping("/get-all")
    public ResponseDto<List<AuthorDto>> getAllAuthor() {
        return this.authorService.getAll();
    }
}
