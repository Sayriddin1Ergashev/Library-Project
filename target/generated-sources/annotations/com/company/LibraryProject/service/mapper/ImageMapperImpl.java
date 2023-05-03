package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.model.Image;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T16:59:33+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public Image toEntity(ImageDto imageDto) {
        if ( imageDto == null ) {
            return null;
        }

        Image image = new Image();

        image.setPath( imageDto.getPath() );
        image.setType( imageDto.getType() );
        image.setSize( imageDto.getSize() );
        image.setToken( imageDto.getToken() );

        return image;
    }

    @Override
    public ImageDto toDto(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDto imageDto = new ImageDto();

        if ( image.getCreatedAt() != null ) {
            imageDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( image.getCreatedAt() ) );
        }
        if ( image.getUpdatedAt() != null ) {
            imageDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( image.getUpdatedAt() ) );
        }
        if ( image.getDeletedAt() != null ) {
            imageDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( image.getDeletedAt() ) );
        }
        imageDto.setImageId( image.getImageId() );
        imageDto.setPath( image.getPath() );
        imageDto.setType( image.getType() );
        imageDto.setSize( image.getSize() );
        imageDto.setToken( image.getToken() );

        return imageDto;
    }
}
