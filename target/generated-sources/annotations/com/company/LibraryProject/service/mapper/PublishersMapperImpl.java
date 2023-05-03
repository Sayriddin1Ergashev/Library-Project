package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.PublishersDto;
import com.company.LibraryProject.model.Publisher;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T17:30:06+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class PublishersMapperImpl extends PublishersMapper {

    @Override
    public PublishersDto toDto(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublishersDto publishersDto = new PublishersDto();

        publishersDto.setPublisherId( publisher.getPublisherId() );
        publishersDto.setPublisher( publisher.getPublisher() );
        publishersDto.setLocation( publisher.getLocation() );
        publishersDto.setCreatedAt( publisher.getCreatedAt() );
        publishersDto.setUpdatedAt( publisher.getUpdatedAt() );
        publishersDto.setDeletedAt( publisher.getDeletedAt() );

        return publishersDto;
    }

    @Override
    public Publisher toEntity(PublishersDto dto) {
        if ( dto == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        publisher.setPublisherId( dto.getPublisherId() );
        publisher.setPublisher( dto.getPublisher() );
        publisher.setLocation( dto.getLocation() );
        publisher.setCreatedAt( dto.getCreatedAt() );
        publisher.setUpdatedAt( dto.getUpdatedAt() );
        publisher.setDeletedAt( dto.getDeletedAt() );

        return publisher;
    }
}
