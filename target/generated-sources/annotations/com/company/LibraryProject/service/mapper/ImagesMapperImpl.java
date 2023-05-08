package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.ImagesDto;
import com.company.LibraryProject.model.Images;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T16:04:47+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
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
}
