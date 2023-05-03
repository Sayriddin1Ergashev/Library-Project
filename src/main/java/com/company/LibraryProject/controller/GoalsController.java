package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.GoalsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("goals")
public class GoalsController {
    private final GoalsService goalsService;

    @PostMapping("/create")
    public ResponseDto<GoalsDto> createGoals(@Valid @RequestBody GoalsDto goalsDto) {
        return this.goalsService.create(goalsDto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<GoalsDto> gerGoals(@PathVariable(value = "id") Integer goalsId) {

        return goalsService.get(goalsId);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<GoalsDto> updateGoals(@PathVariable(value = "id") Integer goalsId,@Valid @RequestBody GoalsDto goalsDto) {
        return this.goalsService.update(goalsId, goalsDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<GoalsDto> deleteGoals(@PathVariable(value = "id") Integer goalsId) {
        return this.goalsService.delete(goalsId);
    }

    @GetMapping("/get-all")
    public ResponseDto<List<GoalsDto>> getAllGoals() {
        return this.goalsService.getAll();
    }

}
