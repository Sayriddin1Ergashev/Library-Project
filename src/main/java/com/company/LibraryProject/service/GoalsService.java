package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Goals;
import com.company.LibraryProject.repository.GoalsRepository;
import com.company.LibraryProject.service.mapper.GoalsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GoalsService {
   private final GoalsRepository goalsRepository;
    private final GoalsMapper goalsMapper;

    public ResponseDto<GoalsDto> create(GoalsDto goalsDto) {
        try {
            Goals goals = this.goalsMapper.toEntity(goalsDto);
            goals.setCreatedAt(LocalDateTime.now());
            this.goalsRepository.save(goals);
            log.info(String.format("This is goals %d id successful created", goals.getGoalsId()));
            return ResponseDto.<GoalsDto>builder()
                    .message("Goals successful created!")
                    .code(0)
                    .success(true)
                    .data(goalsMapper.toDto(goals))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .message(String.format("Goals while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<GoalsDto> get(Integer id) {
        Optional<Goals> optional = this.goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<GoalsDto>builder()
                    .message(String.format("This is goals %d id not found!",id))
                    .code(-1)
                    .build();
        }
        return ResponseDto.<GoalsDto>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(goalsMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<GoalsDto> update(Integer id, GoalsDto goalsDto) {
        Optional<Goals> optional = this.goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<GoalsDto>builder()
                    .message(String.format("This is goals %d id not found!",id))
                    .code(-1)
                    .build();
        }
        try {
            Goals goals = this.goalsMapper.toEntity(goalsDto);
            goals.setUpdatedAt(LocalDateTime.now());
            goals.setCreatedAt(optional.get().getCreatedAt());
            goals.setGoalsId(optional.get().getGoalsId());
            this.goalsRepository.save(goals);
            log.info(String.format("This goals %d id successful updated!", goals.getGoalsId()));
            return ResponseDto.<GoalsDto>builder()
                    .message(String.format("This goals %d id successful updated!", goals.getGoalsId()))
                    .code(0)
                    .success(true)
                    .data(goalsMapper.toDto(goals))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .message(String.format("Goals while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<GoalsDto> delete(Integer id) {
        Optional<Goals> optional = this.goalsRepository.findByGoalsIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<GoalsDto>builder()
                    .message(String.format("This is goals %d id not found!", id))
                    .code(-1)
                    .build();
        }
        try {
            Goals goals = optional.get();
            goals.setDeletedAt(LocalDateTime.now());
            this.goalsRepository.save(goals);
            log.info(String.format("This goals %d id successful deleted!", goals.getGoalsId()));
            return ResponseDto.<GoalsDto>builder()
                    .message(String.format("This goals %d id successful deleted!", goals.getGoalsId()))
                    .code(0)
                    .success(true)
                    .data(goalsMapper.toDto(goals))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<GoalsDto>builder()
                    .message(String.format("Goals while saving error :: %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<List<GoalsDto>> getAll() {
        return ResponseDto.<List<GoalsDto>>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(this.goalsRepository
                        .findAll()
                        .stream()
                        .map(goalsMapper::toDto)
                        .toList())
                .build();
    }
}
