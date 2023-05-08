package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.model.Authors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T16:04:47+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl extends AuthorMapper {

    @Override
    public Authors toEntity(AuthorDto dto) {
        if ( dto == null ) {
            return null;
        }

        Authors authors = new Authors();

        if ( dto.getAuthorId() != null ) {
            authors.setAuthorId( Integer.parseInt( dto.getAuthorId() ) );
        }
        authors.setFirstname( dto.getFirstname() );
        authors.setLastname( dto.getLastname() );
        authors.setAge( dto.getAge() );
        authors.setCreatedAt( dto.getCreatedAt() );
        authors.setUpdatedAt( dto.getUpdatedAt() );
        authors.setDeletedAt( dto.getDeletedAt() );

        return authors;
    }

    @Override
    public AuthorDto toDto(Authors authors) {
        if ( authors == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        if ( authors.getAuthorId() != null ) {
            authorDto.setAuthorId( String.valueOf( authors.getAuthorId() ) );
        }
        authorDto.setFirstname( authors.getFirstname() );
        authorDto.setLastname( authors.getLastname() );
        authorDto.setAge( authors.getAge() );
        authorDto.setCreatedAt( authors.getCreatedAt() );
        authorDto.setUpdatedAt( authors.getUpdatedAt() );
        authorDto.setDeletedAt( authors.getDeletedAt() );

        return authorDto;
    }

    @Override
    public AuthorDto toDtoNotAuthorId(Authors authors) {
        if ( authors == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setFirstname( authors.getFirstname() );
        authorDto.setLastname( authors.getLastname() );
        authorDto.setAge( authors.getAge() );
        authorDto.setCreatedAt( authors.getCreatedAt() );
        authorDto.setUpdatedAt( authors.getUpdatedAt() );
        authorDto.setDeletedAt( authors.getDeletedAt() );

        return authorDto;
    }
}
