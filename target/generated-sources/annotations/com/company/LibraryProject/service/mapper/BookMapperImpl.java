package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.model.Book;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T17:20:32+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl extends BookMapper {

    @Override
    public Book toEntity(BooksDto dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setBookId( dto.getBookId() );
        book.setName( dto.getName() );
        book.setPrice( dto.getPrice() );
        book.setPage( dto.getPage() );
        book.setAmount( dto.getAmount() );
        book.setPublisherAt( dto.getPublisherAt() );
        book.setCreatedAt( dto.getCreatedAt() );
        book.setUpdatedAt( dto.getUpdatedAt() );
        book.setDeletedAt( dto.getDeletedAt() );

        return book;
    }

    @Override
    public BooksDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BooksDto booksDto = new BooksDto();

        booksDto.setBookId( book.getBookId() );
        booksDto.setName( book.getName() );
        booksDto.setPrice( book.getPrice() );
        booksDto.setPage( book.getPage() );
        booksDto.setAmount( book.getAmount() );
        booksDto.setPublisherAt( book.getPublisherAt() );
        booksDto.setCreatedAt( book.getCreatedAt() );
        booksDto.setUpdatedAt( book.getUpdatedAt() );
        booksDto.setDeletedAt( book.getDeletedAt() );

        return booksDto;
    }
}
