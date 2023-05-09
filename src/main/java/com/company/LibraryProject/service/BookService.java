package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Book;
import com.company.LibraryProject.repository.BookRepository;
import com.company.LibraryProject.service.mapper.BookMapper;
import com.company.LibraryProject.service.validation.BookValidate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final BookValidate bookValidate;
    public ResponseDto<BooksDto> createBook(BooksDto dto) {
        List<ErrorDto> errors = bookValidate.validate(dto);
        if (!errors.isEmpty()) {
            return ResponseDto.<BooksDto>builder()
                    .message("Validation error")
                    .data(dto)
                    .errors(errors)
                    .code(-2)
                    .build();
        }

        try {
            Book book = bookMapper.toEntity(dto);
            book.setCreatedAt(LocalDateTime.now());
            bookRepository.save(book);
            log.info(String.format("Created book by id %d successfully!", book.getBookId()));

            return ResponseDto.<BooksDto>builder()
                    .success(true)
                    .message("Book successful created!")
                    .data(bookMapper.toDto(book)) // TODO: dto berilgan ekan toDto berdim
                    .build();
        } catch (Exception e) {
            log.warn(String.format("Book while saving error :: %s", e.getMessage()));
            return ResponseDto.<BooksDto>builder()
                    .message("Book while saving error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }


    public ResponseDto<BooksDto> getBook(Integer bookId) {
        Optional<Book> optional = bookRepository.findByBookIdAndDeletedAtIsNull(bookId);
        if (optional.isEmpty()) {
            return ResponseDto.<BooksDto>builder()
                    .message("Book is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<BooksDto>builder()
                .success(true)
                .message("OK")
                .data(bookMapper.toDto(optional.get()))
                .build();
    }


    public ResponseDto<BooksDto> updateBook(BooksDto dto, Integer bookId) {
        List<ErrorDto> errors = bookValidate.validate(dto);
        if (!errors.isEmpty()) {
            return ResponseDto.<BooksDto>builder()
                    .message("Validation error")
              //      .data(dto)    TODO: Kerak emas uchirdim
                    .errors(errors)
                    .code(-2)
                    .build();
        }

        Optional<Book> optional = bookRepository.findByBookIdAndDeletedAtIsNull(bookId);
        if (optional.isEmpty()) {
            return ResponseDto.<BooksDto>builder()
                    .message("Book is not found!")
                    .code(-3)
                    .build();
        }

        try {

            Book book = bookMapper.toEntity(dto);
            book.setBookId(optional.get().getBookId());
            book.setCreatedAt(optional.get().getCreatedAt());
         //   book.setDeletedAt(optional.get().getDeletedAt());  TODO: kerak emas uchirdim
            book.setUpdatedAt(LocalDateTime.now());
            bookRepository.save(book);
            log.info("Book successful updated!");

            return ResponseDto.<BooksDto>builder()
                    .success(true)
                    .data(bookMapper.toDto(book)) // TODO: data quyilmagan ekan qushdim
                    .message("OK")
                    .build();

        } catch (Exception e) {
            log.warn(String.format("Book while saving error :: %s", e.getMessage()));
            return ResponseDto.<BooksDto>builder()
                    .message("Book while saving error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }


    public ResponseDto<BooksDto> deleteBook(Integer bookId) {
        Optional<Book> optional = bookRepository.findByBookIdAndDeletedAtIsNull(bookId);
        if (optional.isEmpty()) {
            return ResponseDto.<BooksDto>builder()
                    .message("Book is not found!")
                    .code(-3)
                    .build();
        }
        try {
            Book book = optional.get();
            book.setDeletedAt(LocalDateTime.now());
            bookRepository.save(book);
            log.info("Book successful deleted!");

            return ResponseDto.<BooksDto>builder()
                    .message("OK")
                    .success(true)
                    .data(bookMapper.toDto(book))
                    .build();

        } catch (Exception e) {
            log.warn(String.format("Book while saving error :: %s", e.getMessage()));
            return ResponseDto.<BooksDto>builder()
                    .message("Book while saving error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }
}
