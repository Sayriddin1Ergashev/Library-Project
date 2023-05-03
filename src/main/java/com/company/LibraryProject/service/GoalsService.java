package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Goals;
import com.company.LibraryProject.repository.GoalsRepository;
import com.company.LibraryProject.service.mapper.GoalsMapper;
import com.company.LibraryProject.service.validation.GoalsValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoalsService {

    private final GoalsMapper goalsMapper;
    private final GoalsRepository goalsRepository;
    private final GoalsValidation goalsValidation;

    public ResponseDto<GoalsDto> createGoals(GoalsDto dto) {
        try {
            Goals goals = goalsMapper.toEntity(dto);
            goals.setCreatedAt(LocalDateTime.now());
            goalsRepository.save(goals);
            return ResponseDto.<GoalsDto>builder()
                    .message("Ok")
                    .code(0)
                    .success(true)
                    .data(goalsMapper.toDto(goals))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .success(false)
                    .code(-3)
                    .message("Goals saving error" + e.getMessage())
                    .build();
        }
    }

    public ResponseDto<GoalsDto> getGoals(Integer id) {

        try {
            Optional<Goals> optional = goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<GoalsDto>builder()
                        .success(false)
                        .code(-1)
                        .message("Goals %s is not found " + id)
                        .build();
            }
            return ResponseDto.<GoalsDto>builder()
                    .message("Ok")
                    .code(0)
                    .success(true)
                    .data(goalsMapper.toDto(optional.get()))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .success(false)
                    .code(-3)
                    .message("Goals saving error " + e.getMessage())
                    .build();
        }
    }

    public ResponseDto<GoalsDto> updateGoals(GoalsDto dto, Integer id) {
        try {
            Optional<Goals> optional = goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<GoalsDto>builder()
                        .success(false)
                        .code(-1)
                        .message("Goals %s is not found " + id)
                        .build();
            }
            Goals goals = goalsMapper.toEntity(dto);
            goals.setUpdatedAt(LocalDateTime.now());
            goals.setGoalsId(optional.get().getGoalsId());
            goals.setCreatedAt(optional.get().getCreatedAt());
            goalsRepository.save(goals);
            return ResponseDto.<GoalsDto>builder()
                    .message("Ok")
                    .code(0)
                    .success(true)
                    .data(goalsMapper.toDto(goals))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .success(false)
                    .code(-3)
                    .message("Goals saving error" + e.getMessage())
                    .build();
        }
    }

    public ResponseDto<GoalsDto> deleteGoals(Integer id) {
        try {
            Optional<Goals> optional = goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<GoalsDto>builder()
                        .success(false)
                        .code(-1)
                        .message("Goals %s is not found " + id)
                        .build();
            }
            Goals goals = optional.get();
            goals.setDeletedAt(LocalDateTime.now());
            goals.setUpdatedAt(optional.get().getUpdatedAt());
            goals.setGoalsId(optional.get().getGoalsId());
            goals.setCreatedAt(optional.get().getCreatedAt());
            goalsRepository.save(goals);
            return ResponseDto.<GoalsDto>builder()
                    .message("Ok")
                    .code(0)
                    .success(true)
                    .data(goalsMapper.toDto(goals))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .success(false)
                    .code(-3)
                    .message("Goals saving error" + e.getMessage())
                    .build();
        }
}
}
