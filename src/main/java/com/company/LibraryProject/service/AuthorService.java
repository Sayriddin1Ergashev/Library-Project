package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Author;
import com.company.LibraryProject.repository.AuthorRepository;
import com.company.LibraryProject.service.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    public ResponseDto<AuthorDto> create(AuthorDto authorDto) {
        try {
            Author author = authorMapper.toEntity(authorDto);
            author.setCreatedAt(LocalDateTime.now());
            this.authorRepository.save(author);
            log.info(String.format("This is author %d id successful created!", author.getAuthorId()));
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("This is author %d id successful created!", author.getAuthorId()))
                    .code(0)
                    .success(true)
                    .data(authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("Author while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<AuthorDto> get(Integer id) {
        Optional<Author> optional = this.authorRepository.findByAuthorIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("this is Author %d id not found!",id))
                    .code(-1)
                    .build();
        }
        return ResponseDto.<AuthorDto>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(authorMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<AuthorDto> update(Integer id, AuthorDto authorDto) {
        Optional<Author> optional = this.authorRepository.findByAuthorIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("this is Author %d id not found!",id))
                    .code(-1)
                    .build();
        }
        try {
            Author author = this.authorMapper.toEntity(authorDto);
            author.setUpdatedAt(LocalDateTime.now());
            author.setCreatedAt(optional.get().getCreatedAt());
            author.setAuthorId(optional.get().getAuthorId());
            this.authorRepository.save(author);
            log.info(String.format("This is Author %d id successful updated!", author.getAuthorId()));
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("This is Author %d id successful updated!", author.getAuthorId()))
                    .code(0)
                    .success(true)
                    .data(authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("Author while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<AuthorDto> delete(Integer id) {
        Optional<Author> optional = authorRepository.findByAuthorIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("this is Author %d id not found!", id))
                    .code(-1)
                    .build();
        }
        try {
            Author author = optional.get();
            author.setDeletedAt(LocalDateTime.now());
            this.authorRepository.save(author);
            log.info(String.format("This is author %d id successful deleted!", author.getAuthorId()));
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("This is author %d id successful deleted!", author.getAuthorId()))
                    .code(0)
                    .success(true)
                    .data(authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("Author while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<List<AuthorDto>> getAll() {
        return ResponseDto.<List<AuthorDto>>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(this.authorRepository
                        .findAll()
                        .stream()
                        .map(this.authorMapper::toDto)
                        .toList())
                .build();
    }
}
