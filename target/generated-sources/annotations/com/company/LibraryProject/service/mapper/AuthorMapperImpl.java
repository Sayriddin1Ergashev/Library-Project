package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.model.Author;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T20:22:57+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public Author toEntity(AuthorDto dto) {
        if ( dto == null ) {
            return null;
        }

        Author author = new Author();

        author.setFirstname( dto.getFirstname() );
        author.setLastname( dto.getLastname() );
        author.setAge( dto.getAge() );

        return author;
    }

    @Override
    public AuthorDto toDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        if ( author.getCreatedAt() != null ) {
            authorDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( author.getCreatedAt() ) );
        }
        if ( author.getUpdatedAt() != null ) {
            authorDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( author.getUpdatedAt() ) );
        }
        if ( author.getDeletedAt() != null ) {
            authorDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( author.getDeletedAt() ) );
        }
        authorDto.setAuthorId( author.getAuthorId() );
        authorDto.setFirstname( author.getFirstname() );
        authorDto.setLastname( author.getLastname() );
        authorDto.setAge( author.getAge() );

        return authorDto;
    }
}
