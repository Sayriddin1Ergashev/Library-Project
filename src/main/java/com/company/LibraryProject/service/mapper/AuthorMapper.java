package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.AuthorDto;
import com.company.LibraryProject.model.Authors;

public abstract class AuthorMapper {

    public abstract Authors toEntity(AuthorDto dto);

    public abstract AuthorDto toDto(Authors authors);
}
