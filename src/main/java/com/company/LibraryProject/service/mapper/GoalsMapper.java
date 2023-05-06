package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.model.Goals;
import com.company.LibraryProject.service.BookService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class GoalsMapper {

    @Autowired
    protected BookService bookService;
    @Autowired
    protected BookMapper bookMapper;

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Goals toEntity(GoalsDto goalsDto);

    public abstract GoalsDto toDto(Goals goals);
}
