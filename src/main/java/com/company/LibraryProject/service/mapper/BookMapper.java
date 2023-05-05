package com.company.LibraryProject.service.mapper;
import com.company.LibraryProject.dto.BooksDto;
import com.company.LibraryProject.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class})
public abstract class BookMapper {

    @Lazy
    @Autowired
    protected AuthorsMapper authorsMapper;

    @Lazy
    @Autowired
    protected ImagesMapper imagesMapper;

    @Lazy
    @Autowired
    protected GoalsMapper goalsMapper;

    @Lazy
    @Autowired
    protected PublisherMapper publisherMapper;

    public abstract Book toEntity(BooksDto dto);

    //    @Mapping(target = "authorsDto", expression = "java(user.getCards().stream().map(cardMapper::toDtoNotUserId).collect(Collectors.toSet()))")
//    public abstract BooksDto toDto(Book book);
    @Mapping(target = "authorsDto",
            expression = "java(book.getAuthors().stream().map(authorsMapper::toDtoNotAuthorId).collect(Collectors.toSet()))")
    @Mapping(target = "imagesDto",
            expression = "java(book.getImages().stream().map(imagesMapper::toDtoNotBookId).collect(Collectors.toSet()))")
    @Mapping(target = "goalsDto",
            expression = "java(goalsMapper.toDtoNotBookId(book.getGoals()))")
    @Mapping(target = "publisherDto",
            expression = "java(publisherMapper.toDtoNotBookId(book.getPublisher()))")
    public abstract BooksDto toDto(Book book);



}