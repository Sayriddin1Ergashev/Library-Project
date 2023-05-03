package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.model.Books;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T18:57:55+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class BooksMapperImpl extends BooksMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public Books toEntity(BooksDto booksDto) {
        if ( booksDto == null ) {
            return null;
        }

        Books books = new Books();

        books.setName( booksDto.getName() );
        books.setPrice( booksDto.getPrice() );
        books.setPage( booksDto.getPage() );
        books.setPublished( booksDto.getPublished() );
        books.setAmount( booksDto.getAmount() );

        return books;
    }

    @Override
    public BooksDto toDto(Books books) {
        if ( books == null ) {
            return null;
        }

        BooksDto booksDto = new BooksDto();

        if ( books.getCreatedAt() != null ) {
            booksDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( books.getCreatedAt() ) );
        }
        if ( books.getUpdatedAt() != null ) {
            booksDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( books.getUpdatedAt() ) );
        }
        if ( books.getDeletedAt() != null ) {
            booksDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( books.getDeletedAt() ) );
        }
        booksDto.setBooksId( books.getBooksId() );
        booksDto.setName( books.getName() );
        booksDto.setPrice( books.getPrice() );
        booksDto.setPage( books.getPage() );
        booksDto.setPublished( books.getPublished() );
        booksDto.setAmount( books.getAmount() );

        booksDto.setGoalsDto( books.getGoals().stream().map(goalsMapper::toDto).collect(Collectors.toSet()) );
        booksDto.setImageDto( imageMapper.toDto(books.getImage()) );

        return booksDto;
    }

    @Override
    public BooksDto toDtoByNotId(Books books) {
        if ( books == null ) {
            return null;
        }

        BooksDto booksDto = new BooksDto();

        if ( books.getCreatedAt() != null ) {
            booksDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( books.getCreatedAt() ) );
        }
        if ( books.getUpdatedAt() != null ) {
            booksDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( books.getUpdatedAt() ) );
        }
        if ( books.getDeletedAt() != null ) {
            booksDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( books.getDeletedAt() ) );
        }
        booksDto.setBooksId( books.getBooksId() );
        booksDto.setName( books.getName() );
        booksDto.setPrice( books.getPrice() );
        booksDto.setPage( books.getPage() );
        booksDto.setPublished( books.getPublished() );
        booksDto.setAmount( books.getAmount() );

        return booksDto;
    }
}
