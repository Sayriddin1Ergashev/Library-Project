package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.model.Books;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BooksMapper {

    public abstract BooksDto toDto(Books books);
    public abstract Books toEntity(BooksDto dto);


    public abstract BooksDto toDtoNotId(Books books);
}
