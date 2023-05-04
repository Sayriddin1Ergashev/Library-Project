package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.CardDto;
import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Card;
import com.company.LibraryProject.model.Goals;
import com.company.LibraryProject.repository.GoalsRepository;
import com.company.LibraryProject.service.mapper.GoalsMapper;
import com.company.LibraryProject.service.validation.GoalsValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoalsService {

    private final GoalsMapper goalsMapper;

    private final GoalsRepository goalsRepository;

    private final GoalsValidate goalsValidate;

    public ResponseDto<GoalsDto> createGoals(GoalsDto goalsDto) {
        List<ErrorDto> errors = goalsValidate.validate(goalsDto);
        if (!errors.isEmpty()){
            return ResponseDto.<GoalsDto>builder()
                    .message("Validation error")
                    .code(-2)
                    .data(goalsDto)
                    .errors(errors)
                    .build();
        }

        try {
            Goals goals=goalsMapper.toEntity(goalsDto);
            goals.setCreatedAt(LocalDateTime.now());
            goalsRepository.save(goals);

            return ResponseDto.<GoalsDto>builder()
                    .message("OK")
                    .success(true)
                    .data(goalsMapper.toDto(goals))
                    .build();

        } catch (Exception c) {
            return ResponseDto.<GoalsDto>builder()
                    .code(-3)
                    .message("Goals while saving error: " + c.getMessage())
                    .build();

        }
    }

    public ResponseDto<GoalsDto> getGoals(Integer id) {
        try {
            Optional<Goals> optional = goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<GoalsDto>builder()
                        .message("Goals is not found!")
                        .code(-1)
                        .build();
            }

            return ResponseDto.<GoalsDto>builder()
                    .message("OK")
                    .success(true)
                    .data(goalsMapper.toDto(optional.get()))
                    .build();

        } catch (Exception c) {
            return ResponseDto.<GoalsDto>builder()
                    .code(-3)
                    .message("Database Error: " + c.getMessage())
                    .data(null)
                    .build();
        }
    }

    public ResponseDto<GoalsDto> updateGoals(GoalsDto goalsDto, Integer id) {

        List<ErrorDto> errors = goalsValidate.validate(goalsDto);
        if (!errors.isEmpty()){
            return ResponseDto.<GoalsDto>builder()
                    .message("Validation error")
                    .code(-2)
                    .data(goalsDto)
                    .errors(errors)
                    .build();
        }

        Optional<Goals> optional = goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<GoalsDto>builder()
                    .code(-1)
                    .message("Goals is not found!")
                    .build();
        }

        try {
            Goals goals=goalsMapper.toEntity(goalsDto);
            goals.setGoalsId(optional.get().getGoalsId());
            goals.setCreatedAt(optional.get().getCreatedAt());
            goals.setDeletedAt(optional.get().getDeletedAt());
            goals.setUpdatedAt(LocalDateTime.now());
            goalsRepository.save(goals);
            return ResponseDto.<GoalsDto>builder()
                    .message("OK")
                    .success(true)
                    .data(goalsMapper.toDto(goals))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .message("Goals while saving error :: {}" + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<GoalsDto> deleteGoals(Integer id) {
        Optional<Goals> optional = goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<GoalsDto>builder()
                    .code(-1)
                    .message("Goals is not found!")
                    .build();
        }
        try {
            Goals goals = optional.get();
            goals.setDeletedAt(LocalDateTime.now());
            goalsRepository.save(goals);
            return ResponseDto.<GoalsDto>builder()
                    .success(true)
                    .message("OK")
                    .data(goalsMapper.toDto(goals))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .message("Goals while saving error :: {}" + e.getMessage())
                    .code(-3)
                    .build();
        }
    }
}
