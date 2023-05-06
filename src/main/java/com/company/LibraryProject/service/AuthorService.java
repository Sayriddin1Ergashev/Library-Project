package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Authors;
import com.company.LibraryProject.repository.AuthorRepository;
import com.company.LibraryProject.service.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public ResponseDto<AuthorDto> create(AuthorDto dto) {
        try {
            Authors author = authorMapper.toEntity(dto);
            author.setCreatedAt(LocalDateTime.now());
            this.authorRepository.save(author);
            return ResponseDto.<AuthorDto>builder()
                    .message("author created")
                    .code(0)
                    .success(true)
                    .data(authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .message("author not saving")
                    .code(-3)
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<AuthorDto> get(Integer authorId) {
        try {
            Optional<Authors> optional = authorRepository.findAllByAuthorIdAndDeletedAtIsNull(authorId);
            if (optional.isEmpty()) {
                return ResponseDto.<AuthorDto>builder()
                        .message("author is empty")
                        .code(-1)
                        .success(false)
                        .build();
            }
            return ResponseDto.<AuthorDto>builder()
                    .message("author has found")
                    .code(0)
                    .success(true)
                    .data(authorMapper.toDto(optional.get()))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .message("author not found")
                    .code(-3)
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<AuthorDto> update(AuthorDto dto, Integer authorId) {
        Optional<Authors> optional = authorRepository.findAllByAuthorIdAndDeletedAtIsNull(authorId);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorDto>builder()
                    .message("author not found")
                    .code(-3)
                    .build();
        }
        try {
            Authors author = authorMapper.toEntity(dto);
            author.setAuthorId(optional.get().getAuthorId());
            author.setCreatedAt(optional.get().getCreatedAt());
            author.setDeletedAt(optional.get().getDeletedAt());
            author.setUpdatedAt(LocalDateTime.now());
            authorRepository.save(author);
            return ResponseDto.<AuthorDto>builder()
                    .message("successfully updated")
                    .code(0)
                    .data(authorMapper.toDto(author))
                    .build();
        }
        catch (Exception e){
            return ResponseDto.<AuthorDto>builder()
                    .message("Database error")
                    .code(-3)
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<AuthorDto> delete(Integer authorId) {
        Optional<Authors> optional = authorRepository.findAllByAuthorIdAndDeletedAtIsNull(authorId);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorDto>builder()
                    .message("author not found")
                    .code(-3)
                    .build();
        }
        try {
            Authors author = optional.get();
            author.setDeletedAt(LocalDateTime.now());
            authorRepository.save(author);
            return ResponseDto.<AuthorDto>builder()
                    .message("successfully deleted")
                    .code(0)
                    .data(authorMapper.toDto(author))
                    .build();
        }
        catch (Exception e){
            return ResponseDto.<AuthorDto>builder()
                    .message("Database error")
                    .code(-3)
                    .build();
        }

    }
}
