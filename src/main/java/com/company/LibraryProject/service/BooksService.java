package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Books;
import com.company.LibraryProject.repository.BooksRepository;
import com.company.LibraryProject.service.mapper.BooksMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BooksService {
    private final BooksMapper booksMapper;
    private final BooksRepository booksRepository;
    public ResponseDto<BooksDto> create(BooksDto booksDto) {
        try {
            Books books=this.booksMapper.toEntity(booksDto);
            books.setCreatedAt(LocalDateTime.now());
            this.booksRepository.save(books);
            log.info(String.format("This is book %d id successful created!",books.getBooksId()));
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("This is book %d id successful created!",books.getBooksId()))
                    .code(0)
                    .success(true)
                    .data(booksMapper.toDtoByNotId(books))
                    .build();
        }catch (Exception e){
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("Book while saving error :: %s",e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<BooksDto> get(Integer id) {
        Optional<Books> optional=booksRepository.findByBooksIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("This is book %d id not found!",id))
                    .code(-1)
                    .build();
        }
        return ResponseDto.<BooksDto>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(booksMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<BooksDto> update(Integer id, BooksDto booksDto) {
        Optional<Books>optional=this.booksRepository.findByBooksIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("This is book %d id not found!",id))
                    .code(-1)
                    .build();
        }
        try {
            Books books=this.booksMapper.toEntity(booksDto);
            books.setUpdatedAt(LocalDateTime.now());
            books.setCreatedAt(optional.get().getCreatedAt());
            books.setBooksId(optional.get().getBooksId());
            this.booksRepository.save(books);
            log.info(String.format("This is book %d id successfull updated!",books.getBooksId()));
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("This is book %d id successfull updated!",books.getBooksId()))
                    .code(0)
                    .success(true)
                    .data(booksMapper.toDtoByNotId(books))
                    .build();
        }catch (Exception e){
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("Book while saving error :: %s",e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<BooksDto> delete(Integer id) {
        Optional<Books>optional=this.booksRepository.findByBooksIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("This is book %d id not found!",id))
                    .code(-1)
                    .build();
        }
        try {
            Books books=optional.get();
            books.setDeletedAt(LocalDateTime.now());
            this.booksRepository.save(books);
            log.info(String.format("This is book %d id successfull deleted!",books.getBooksId()));
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("This is book %d id successfull deleted!",books.getBooksId()))
                    .code(0)
                    .success(true)
                    .data(booksMapper.toDto(books))
                    .build();
        }catch (Exception e){
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("Book while saving error :: %s",e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<List<BooksDto>> getAll() {
        return ResponseDto.<List<BooksDto>>builder()
                .message("Ok")
                .success(true)
                .code(0)
                .data(booksRepository
                        .findAll()
                        .stream()
                        .map(this.booksMapper::toDto)
                        .toList())
                .build();
    }
}
