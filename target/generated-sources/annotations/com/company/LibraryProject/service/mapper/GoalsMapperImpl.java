package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.model.Goals;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T20:14:00+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class GoalsMapperImpl implements GoalsMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public Goals toEntity(GoalsDto goalsDto) {
        if ( goalsDto == null ) {
            return null;
        }

        Goals goals = new Goals();

        goals.setGoalsId( goalsDto.getGoalsId() );
        goals.setLanguage( goalsDto.getLanguage() );
        goals.setDescription( goalsDto.getDescription() );
        goals.setBookId( goalsDto.getBookId() );

        return goals;
    }

    @Override
    public GoalsDto toDto(Goals goals) {
        if ( goals == null ) {
            return null;
        }

        GoalsDto goalsDto = new GoalsDto();

        if ( goals.getCreatedAt() != null ) {
            goalsDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( goals.getCreatedAt() ) );
        }
        if ( goals.getUpdatedAt() != null ) {
            goalsDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( goals.getUpdatedAt() ) );
        }
        if ( goals.getDeletedAt() != null ) {
            goalsDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( goals.getDeletedAt() ) );
        }
        goalsDto.setGoalsId( goals.getGoalsId() );
        goalsDto.setLanguage( goals.getLanguage() );
        goalsDto.setDescription( goals.getDescription() );
        goalsDto.setBookId( goals.getBookId() );

        return goalsDto;
    }

    @Override
    public GoalsDto toDtoNotBookId(Goals goals) {
        if ( goals == null ) {
            return null;
        }

        GoalsDto goalsDto = new GoalsDto();

        if ( goals.getCreatedAt() != null ) {
            goalsDto.setCreatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( goals.getCreatedAt() ) );
        }
        if ( goals.getUpdatedAt() != null ) {
            goalsDto.setUpdatedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( goals.getUpdatedAt() ) );
        }
        if ( goals.getDeletedAt() != null ) {
            goalsDto.setDeletedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( goals.getDeletedAt() ) );
        }
        goalsDto.setGoalsId( goals.getGoalsId() );
        goalsDto.setLanguage( goals.getLanguage() );
        goalsDto.setDescription( goals.getDescription() );

        return goalsDto;
    }
}
