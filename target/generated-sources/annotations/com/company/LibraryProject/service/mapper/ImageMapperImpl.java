package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.model.Image;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-30T10:25:58+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl extends ImageMapper {

    @Override
    public Image toEntity(ImageDto dto) {
        if ( dto == null ) {
            return null;
        }

        Image image = new Image();

        image.setImageId( dto.getImageId() );
        image.setPath( dto.getPath() );
        image.setType( dto.getType() );
        image.setSize( dto.getSize() );
        image.setToken( dto.getToken() );
        image.setCreatedAt( dto.getCreatedAt() );
        image.setUpdatedAt( dto.getUpdatedAt() );
        image.setDeletedAt( dto.getDeletedAt() );

        return image;
    }

    @Override
    public ImageDto toDto(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDto imageDto = new ImageDto();

        imageDto.setImageId( image.getImageId() );
        imageDto.setPath( image.getPath() );
        imageDto.setType( image.getType() );
        imageDto.setSize( image.getSize() );
        imageDto.setToken( image.getToken() );
        imageDto.setCreatedAt( image.getCreatedAt() );
        imageDto.setUpdatedAt( image.getUpdatedAt() );
        imageDto.setDeletedAt( image.getDeletedAt() );

        return imageDto;
    }
}
