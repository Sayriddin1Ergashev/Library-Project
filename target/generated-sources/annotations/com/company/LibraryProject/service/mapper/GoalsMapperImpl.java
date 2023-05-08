package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.model.Goals;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-08T17:20:32+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class GoalsMapperImpl extends GoalsMapper {

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

        goalsDto.setGoalsId( goals.getGoalsId() );
        goalsDto.setLanguage( goals.getLanguage() );
        goalsDto.setDescription( goals.getDescription() );
        goalsDto.setBookId( goals.getBookId() );
        goalsDto.setCreatedAt( goals.getCreatedAt() );
        goalsDto.setUpdatedAt( goals.getUpdatedAt() );
        goalsDto.setDeletedAt( goals.getDeletedAt() );

        return goalsDto;
    }
}
