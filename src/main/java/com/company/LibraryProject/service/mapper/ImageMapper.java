package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.model.Image;
import org.mapstruct.Mapper;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class})
public abstract class ImageMapper {

    public abstract Image toEntity(ImageDto dto);
    public abstract ImageDto toDto(Image image);
}
