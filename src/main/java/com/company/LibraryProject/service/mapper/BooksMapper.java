package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.model.Books;
import com.company.LibraryProject.service.GoalsService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,imports = {Collectors.class})
public abstract class BooksMapper {
    @Lazy
    @Autowired
    protected GoalsMapper goalsMapper;
    @Lazy
    @Autowired
    protected ImageMapper imageMapper;
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "booksId", ignore = true)
    public abstract Books toEntity(BooksDto booksDto);
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "updatedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "deletedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "goalsDto",expression = "java(books.getGoals().stream().map(goalsMapper::toDto).collect(Collectors.toSet()))")
    @Mapping(target = "imageDto",expression = "java(imageMapper.toDto(books.getImage()))")
    public abstract BooksDto toDto(Books books);
    void aVoid(){
        BooksDto booksDto=new BooksDto();
        Books books=new Books();
    //   goals    booksDto.setGoalsDto(books.getGoals().stream().map(goalsMapper::toDto).collect(Collectors.toSet()));
      booksDto.setImageDto(imageMapper.toDto(books.getImage()));
    }
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "updatedAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "deletedAt", dateFormat = "yyyy-MM-dd")
    public abstract BooksDto toDtoByNotId(Books books);
}
