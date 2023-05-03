package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.dto.ResponseDto;

import com.company.LibraryProject.service.GoalsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("goals")
public class GoalsController {
    private final GoalsService goalsService;

    @PostMapping("/create")
    public ResponseDto<GoalsDto> createGoals(@Valid @RequestBody GoalsDto dto){
        return goalsService.createGoals(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<GoalsDto> getGoals(@PathVariable Integer id){
        return goalsService.getGoals(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<GoalsDto> updateGoals(@Valid  @RequestBody GoalsDto dto, @PathVariable Integer id){
        return goalsService.updateGoals(dto, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto<GoalsDto> deleteGoals(@PathVariable Integer id){
        return goalsService.deleteGoals(id);
    }
}
