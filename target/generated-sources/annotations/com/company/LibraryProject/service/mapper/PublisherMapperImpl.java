package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.PublisherDto;
import com.company.LibraryProject.model.Publisher;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T20:14:00+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class PublisherMapperImpl implements PublisherMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

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

        if ( publisher.getCreatedAt() != null ) {
            publisherDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( publisher.getCreatedAt() ) );
        }
        if ( publisher.getUpdatedAt() != null ) {
            publisherDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( publisher.getUpdatedAt() ) );
        }
        if ( publisher.getDeletedAt() != null ) {
            publisherDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( publisher.getDeletedAt() ) );
        }
        publisherDto.setPublisherId( publisher.getPublisherId() );
        publisherDto.setPublisher( publisher.getPublisher() );
        publisherDto.setLocation( publisher.getLocation() );
        publisherDto.setBookId( publisher.getBookId() );

        return publisherDto;
    }

    @Override
    public PublisherDto toDtoNotBookId(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherDto publisherDto = new PublisherDto();

        if ( publisher.getCreatedAt() != null ) {
            publisherDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( publisher.getCreatedAt() ) );
        }
        if ( publisher.getUpdatedAt() != null ) {
            publisherDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( publisher.getUpdatedAt() ) );
        }
        if ( publisher.getDeletedAt() != null ) {
            publisherDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( publisher.getDeletedAt() ) );
        }
        publisherDto.setPublisherId( publisher.getPublisherId() );
        publisherDto.setPublisher( publisher.getPublisher() );
        publisherDto.setLocation( publisher.getLocation() );

        return publisherDto;
    }
}
