package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "imageId", ignore = true)
    Image toEntity(ImageDto imageDto);

    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "updatedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "deletedAt", dateFormat = "yyyy-MM-dd")
    ImageDto toDto(Image image);

}
