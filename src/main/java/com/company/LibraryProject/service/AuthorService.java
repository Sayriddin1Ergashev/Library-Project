package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Author;
import com.company.LibraryProject.repository.AuthorRepository;
import com.company.LibraryProject.service.mapper.AuthorMapper;
import com.company.LibraryProject.service.validation.AuthorValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;
    private final AuthorValidation authorValidation;

    public ResponseDto<AuthorDto> createAuthor(AuthorDto dto) {
        List<ErrorDto> errors=authorValidation.validate(dto);
        if (!errors.isEmpty()){
            return ResponseDto.<AuthorDto>builder()
                    .data(dto)
                    .success(false)
                    .message("Validation error!")
                    .code(-2)
                    .build();
        }
        try {
            Author author = authorMapper.toEntity(dto);
            author.setCreatedAt(LocalDateTime.now());
            authorRepository.save(author);
            return ResponseDto.<AuthorDto>builder()
                    .success(true)
                    .message("ok")
                    .code(0)
                    .data(authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .code(-3)
                    .message("Author saving %s error!" + e.getMessage())
                    .success(false)
                    .build();
        }

    }

    public ResponseDto<AuthorDto> getAuthor(Integer authorId) {
        try {
            Optional<Author> optional = authorRepository.findByAuthorIdAndDeletedAtIsNull(authorId);
            if (optional.isEmpty()) {
                return ResponseDto.<AuthorDto>builder()
                        .code(-1)
                        .data(null)
                        .message("Authors is not found!!!")
                        .success(false)
                        .build();
            }
            return ResponseDto.<AuthorDto>builder()
                    .success(true)
                    .message("ok")
                    .code(0)
                    .data(authorMapper.toDto(optional.get()))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .code(-3)
                    .message("Database Error:" + e.getMessage())
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<AuthorDto> updateAuthor(AuthorDto dto, Integer authorId) {
        List<ErrorDto> errors=authorValidation.validate(dto);
        if (!errors.isEmpty()){
            return ResponseDto.<AuthorDto>builder()
                    .data(dto)
                    .success(false)
                    .message("Validation error!")
                    .code(-2)
                    .build();
        }
        try {
            Optional<Author> optional=authorRepository.findByAuthorIdAndDeletedAtIsNull(authorId);
            if (optional.isEmpty()) {
                return ResponseDto.<AuthorDto>builder()
                        .success(false)
                        .message("Author is not found")
                        .code(-1)
                        .build();
            }
            Author author = authorMapper.toEntity(dto);
            author.setUpdatedAt(LocalDateTime.now());
            author.setAuthorId(optional.get().getAuthorId());
            author.setCreatedAt(optional.get().getCreatedAt());
            authorRepository.save(author);
            return ResponseDto.<AuthorDto>builder()
                    .success(true)
                    .message("ok")
                    .code(0)
                    .data(authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .code(-3)
                    .message("Author update %s error!" + e.getMessage())
                    .success(false)
                    .build();
        }

    }

    public ResponseDto<AuthorDto> deleteAuthor(Integer authorId) {
        try {
            Optional<Author> optional=authorRepository.findByAuthorIdAndDeletedAtIsNull(authorId);
            if (optional.isEmpty()) {
                return ResponseDto.<AuthorDto>builder()
                        .code(-1)
                        .message("Author is not found!")
                        .success(false)
                        .build();
            }
            Author author = optional.get();
            author.setAuthorId(optional.get().getAuthorId());
            author.setCreatedAt(optional.get().getCreatedAt());
            author.setUpdatedAt(optional.get().getUpdatedAt());
            author.setDeletedAt(LocalDateTime.now());
            authorRepository.save(author);
            return ResponseDto.<AuthorDto>builder()
                    .success(true)
                    .message("ok")
                    .code(0)
                    .data(authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .code(-3)
                    .message("Author saving %s error!" + e.getMessage())
                    .success(false)
                    .build();
        }

    }
}
