package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.PublisherDto;
import com.company.LibraryProject.model.Publisher;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
public interface PublisherMapper {
    @Mapping(target = "bookId",ignore = true)
    PublisherDto toDtoNotBookId(Publisher publisher);
    //TODO:bookMapperda ishlatilgan ekan shuning uchun yaratdim.
}
