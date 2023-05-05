package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.model.Goals;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T18:53:19+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class GoalsMapperImpl extends GoalsMapper {

    @Override
    public GoalsDto toDto(Goals goals) {
        if ( goals == null ) {
            return null;
        }

        GoalsDto goalsDto = new GoalsDto();

        goalsDto.setGoalsId( goals.getGoalsId() );
        goalsDto.setName( goals.getName() );
        goalsDto.setLanguage( goals.getLanguage() );
        goalsDto.setCreatedAt( goals.getCreatedAt() );
        goalsDto.setUpdatedAt( goals.getUpdatedAt() );
        goalsDto.setDeletedAt( goals.getDeletedAt() );

        return goalsDto;
    }

    @Override
    public Goals toEntity(GoalsDto dto) {
        if ( dto == null ) {
            return null;
        }

        Goals goals = new Goals();

        goals.setGoalsId( dto.getGoalsId() );
        goals.setName( dto.getName() );
        goals.setLanguage( dto.getLanguage() );

        return goals;
    }

    @Override
    public GoalsDto toDtoNotId(Goals goals) {
        if ( goals == null ) {
            return null;
        }

        GoalsDto goalsDto = new GoalsDto();

        goalsDto.setGoalsId( goals.getGoalsId() );
        goalsDto.setName( goals.getName() );
        goalsDto.setLanguage( goals.getLanguage() );
        goalsDto.setCreatedAt( goals.getCreatedAt() );
        goalsDto.setUpdatedAt( goals.getUpdatedAt() );
        goalsDto.setDeletedAt( goals.getDeletedAt() );

        return goalsDto;
    }
}
