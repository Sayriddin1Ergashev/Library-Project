package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.model.Authors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AuthorMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Authors toEntity(AuthorDto dto);

    public abstract AuthorDto toDto(Authors authors);
}
