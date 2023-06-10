package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.ImagesDto;
import com.company.LibraryProject.model.Images;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-11T01:58:38+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class ImagesMapperImpl implements ImagesMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public Images toEntity(ImagesDto imagesDto) {
        if ( imagesDto == null ) {
            return null;
        }

        Images images = new Images();

        images.setPath( imagesDto.getPath() );
        images.setType( imagesDto.getType() );
        images.setSize( imagesDto.getSize() );
        images.setToken( imagesDto.getToken() );
        images.setBooksId( imagesDto.getBooksId() );

        return images;
    }

    @Override
    public ImagesDto toDto(Images images) {
        if ( images == null ) {
            return null;
        }

        ImagesDto imagesDto = new ImagesDto();

        if ( images.getCreatedAt() != null ) {
            imagesDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( images.getCreatedAt() ) );
        }
        if ( images.getUpdatedAt() != null ) {
            imagesDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( images.getUpdatedAt() ) );
        }
        if ( images.getDeletedAt() != null ) {
            imagesDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( images.getDeletedAt() ) );
        }
        imagesDto.setImageId( images.getImageId() );
        imagesDto.setPath( images.getPath() );
        imagesDto.setType( images.getType() );
        imagesDto.setSize( images.getSize() );
        imagesDto.setToken( images.getToken() );
        imagesDto.setBooksId( images.getBooksId() );

        return imagesDto;
    }

    @Override
    public ImagesDto toDtoNotBookId(Images images) {
        if ( images == null ) {
            return null;
        }

        ImagesDto imagesDto = new ImagesDto();

        if ( images.getCreatedAt() != null ) {
            imagesDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( images.getCreatedAt() ) );
        }
        if ( images.getUpdatedAt() != null ) {
            imagesDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( images.getUpdatedAt() ) );
        }
        if ( images.getDeletedAt() != null ) {
            imagesDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( images.getDeletedAt() ) );
        }
        imagesDto.setPath( images.getPath() );
        imagesDto.setType( images.getType() );
        imagesDto.setSize( images.getSize() );
        imagesDto.setToken( images.getToken() );
        imagesDto.setBooksId( images.getBooksId() );

        return imagesDto;
    }

    @Override
    public void update(Images images, ImagesDto imageDto) {
        if ( imageDto == null ) {
            return;
        }

        if ( imageDto.getImageId() != null ) {
            images.setImageId( imageDto.getImageId() );
        }
        if ( imageDto.getPath() != null ) {
            images.setPath( imageDto.getPath() );
        }
        if ( imageDto.getType() != null ) {
            images.setType( imageDto.getType() );
        }
        if ( imageDto.getSize() != null ) {
            images.setSize( imageDto.getSize() );
        }
        if ( imageDto.getToken() != null ) {
            images.setToken( imageDto.getToken() );
        }
        if ( imageDto.getBooksId() != null ) {
            images.setBooksId( imageDto.getBooksId() );
        }
        if ( imageDto.getCreatedAt() != null ) {
            images.setCreatedAt( LocalDateTime.parse( imageDto.getCreatedAt() ) );
        }
        if ( imageDto.getUpdatedAt() != null ) {
            images.setUpdatedAt( LocalDateTime.parse( imageDto.getUpdatedAt() ) );
        }
        if ( imageDto.getDeletedAt() != null ) {
            images.setDeletedAt( LocalDateTime.parse( imageDto.getDeletedAt() ) );
        }
    }
}
