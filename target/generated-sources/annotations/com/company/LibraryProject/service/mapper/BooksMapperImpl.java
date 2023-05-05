package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.model.Books;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T18:53:19+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class BooksMapperImpl extends BooksMapper {

    @Override
    public BooksDto toDto(Books books) {
        if ( books == null ) {
            return null;
        }

        BooksDto booksDto = new BooksDto();

        booksDto.setBooksId( books.getBooksId() );
        booksDto.setName( books.getName() );
        booksDto.setPrice( books.getPrice() );
        booksDto.setPage( books.getPage() );
        booksDto.setAmount( books.getAmount() );
        booksDto.setPublished( books.getPublished() );
        booksDto.setCreatedAt( books.getCreatedAt() );
        booksDto.setUpdatedAt( books.getUpdatedAt() );
        booksDto.setDeletedAt( books.getDeletedAt() );

        return booksDto;
    }

    @Override
    public Books toEntity(BooksDto dto) {
        if ( dto == null ) {
            return null;
        }

        Books books = new Books();

        books.setBooksId( dto.getBooksId() );
        books.setName( dto.getName() );
        books.setPrice( dto.getPrice() );
        books.setPage( dto.getPage() );
        books.setAmount( dto.getAmount() );
        books.setPublished( dto.getPublished() );
        books.setCreatedAt( dto.getCreatedAt() );
        books.setUpdatedAt( dto.getUpdatedAt() );
        books.setDeletedAt( dto.getDeletedAt() );

        return books;
    }

    @Override
    public BooksDto toDtoNotId(Books books) {
        if ( books == null ) {
            return null;
        }

        BooksDto booksDto = new BooksDto();

        booksDto.setBooksId( books.getBooksId() );
        booksDto.setName( books.getName() );
        booksDto.setPrice( books.getPrice() );
        booksDto.setPage( books.getPage() );
        booksDto.setAmount( books.getAmount() );
        booksDto.setPublished( books.getPublished() );
        booksDto.setCreatedAt( books.getCreatedAt() );
        booksDto.setUpdatedAt( books.getUpdatedAt() );
        booksDto.setDeletedAt( books.getDeletedAt() );

        return booksDto;
    }
}
