package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Books;
import com.company.LibraryProject.repository.BooksRepository;
import com.company.LibraryProject.service.mapper.BooksMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksMapper booksMapper;
    private final BooksRepository booksRepository;

    public ResponseDto<BooksDto> createBooks(BooksDto dto) {

        try {
            Books books = booksMapper.toEntity(dto);
            books.setCreatedAt(LocalDateTime.now());
            booksRepository.save(books);

            return ResponseDto.<BooksDto>builder()
                    .message("OK")
                    .success(true)
                    .data(booksMapper.toDtoNotId(books))
                    .build();


        } catch (Exception c) {
            return ResponseDto.<BooksDto>builder()
                    .code(-3)
                    .message("Card while saving error: " + c.getMessage())
                    .build();

        }
    }

    public ResponseDto<BooksDto> getBooks(Integer booksId) {
        try {
            Optional<Books> optional=booksRepository.findByBooksIdAndDeletedAtIsNull(booksId);
            if (optional.isEmpty()) {
                return ResponseDto.<BooksDto>builder()
                        .message("Books is not found !")
                        .code(-1)
                        .success(false)
                        .build();
            }
            return ResponseDto.<BooksDto>builder()
                    .message("OK")
                    .success(true)
                    .data(booksMapper.toDto(optional.get()))
                    .build();


        } catch (Exception c) {
            return ResponseDto.<BooksDto>builder()
                    .code(-3)
                    .message("Card while saving error: " + c.getMessage())
                    .build();

        }
    }

    public ResponseDto<BooksDto> updateBooks(BooksDto dto, Integer booksId) {
        try {
            Optional<Books> optional=booksRepository.findByBooksIdAndDeletedAtIsNull(booksId);
            if (optional.isEmpty()) {
                return ResponseDto.<BooksDto>builder()
                        .message("Books is not found !")
                        .code(-1)
                        .success(false)
                        .build();
            }
            Books books = booksMapper.toEntity(dto);
            books.setUpdatedAt(LocalDateTime.now());
            books.setCreatedAt(optional.get().getCreatedAt());
            books.setBooksId(optional.get().getBooksId());
            booksRepository.save(books);

            return ResponseDto.<BooksDto>builder()
                    .message("OK")
                    .success(true)
                    .data(booksMapper.toDtoNotId(books))
                    .build();


        } catch (Exception c) {
            return ResponseDto.<BooksDto>builder()
                    .code(-3)
                    .message("Card while saving error: " + c.getMessage())
                    .build();

        }
    }

    public ResponseDto<BooksDto> deleteBooks(Integer booksId) {
        try {
            Optional<Books> optional=booksRepository.findByBooksIdAndDeletedAtIsNull(booksId);
            if (optional.isEmpty()) {
                return ResponseDto.<BooksDto>builder()
                        .message("Books is not found !")
                        .code(-1)
                        .success(false)
                        .build();
            }
            Books books = optional.get();
            books.setDeletedAt(LocalDateTime.now());
            books.setUpdatedAt(optional.get().getUpdatedAt());
            books.setCreatedAt(optional.get().getCreatedAt());
            books.setBooksId(optional.get().getBooksId());
            booksRepository.save(books);

            return ResponseDto.<BooksDto>builder()
                    .message("OK")
                    .success(true)
                    .data(booksMapper.toDto(optional.get()))
                    .build();
        } catch (Exception c) {
            return ResponseDto.<BooksDto>builder()
                    .code(-3)
                    .message("Card while saving error: " + c.getMessage())
                    .build();

        }
    }
}
