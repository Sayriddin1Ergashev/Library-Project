package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.PublisherDto;
import com.company.LibraryProject.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public abstract class PublisherMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "publisherId", ignore = true)
    public abstract Publisher toEntity(PublisherDto dto);

    public abstract PublisherDto toDto(Publisher publisher);

    @Mapping(target = "bookId", ignore = true)
    public abstract PublisherDto toDtoNotBookId(Publisher publisher);


}
