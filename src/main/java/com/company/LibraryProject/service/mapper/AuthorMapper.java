package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.model.Authors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public abstract class AuthorMapper {

    public abstract Authors toEntity(AuthorDto dto);

    public abstract AuthorDto toDto(Authors authors);
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "updatedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "deletedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "authorId",ignore = true)
    public abstract AuthorDto toDtoNotAuthorId(Authors authors);
    //TODO:bookMapperda  toDtoNotAuthorId metodi ishlatilgan ekan shuning uchun yaratib qo'ydim.
}
