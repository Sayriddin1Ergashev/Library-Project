package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.PublisherDto;
import com.company.LibraryProject.model.Publisher;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T17:20:32+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class PublisherMapperImpl extends PublisherMapper {

    @Override
    public Publisher toEntity(PublisherDto dto) {
        if ( dto == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        publisher.setPublisher( dto.getPublisher() );
        publisher.setLocation( dto.getLocation() );
        publisher.setBookId( dto.getBookId() );

        return publisher;
    }

    @Override
    public PublisherDto toDto(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherDto publisherDto = new PublisherDto();

        publisherDto.setPublisherId( publisher.getPublisherId() );
        publisherDto.setPublisher( publisher.getPublisher() );
        publisherDto.setLocation( publisher.getLocation() );
        publisherDto.setBookId( publisher.getBookId() );
        publisherDto.setCreatedAt( publisher.getCreatedAt() );
        publisherDto.setUpdatedAt( publisher.getUpdatedAt() );
        publisherDto.setDeletedAt( publisher.getDeletedAt() );

        return publisherDto;
    }

    @Override
    public PublisherDto toDtoNotBookId(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherDto publisherDto = new PublisherDto();

        publisherDto.setPublisherId( publisher.getPublisherId() );
        publisherDto.setPublisher( publisher.getPublisher() );
        publisherDto.setLocation( publisher.getLocation() );
        publisherDto.setCreatedAt( publisher.getCreatedAt() );
        publisherDto.setUpdatedAt( publisher.getUpdatedAt() );
        publisherDto.setDeletedAt( publisher.getDeletedAt() );

        return publisherDto;
    }
}
