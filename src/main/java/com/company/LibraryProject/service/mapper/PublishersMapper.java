package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.PublishersDto;
import com.company.LibraryProject.model.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PublishersMapper {

    public abstract PublishersDto toDto(Publisher publisher);


    public abstract Publisher toEntity(PublishersDto dto);
}
