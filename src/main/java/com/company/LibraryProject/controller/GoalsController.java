package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.GoalsDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.GoalsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("goals")// TODO: G goals kichkina xarf qilib quydim
@RequiredArgsConstructor
public class GoalsController {

    private final GoalsService goalsService;

    @PostMapping("/create")
    public ResponseDto<GoalsDto> createGoals(@Valid @RequestBody GoalsDto goalsDto){
        return goalsService.createGoals(goalsDto);
    }

    @GetMapping("/get")
    public ResponseDto<GoalsDto> getGoals(@RequestParam Integer id){
        return goalsService.getGoals(id);
    }

    @PutMapping("/updated")
    public ResponseDto<GoalsDto> updateGoals(@Valid @RequestBody GoalsDto goalsDto, @RequestParam Integer id){
        return goalsService.updateGoals(goalsDto,id);
    }

    @DeleteMapping("/deleted")
    public ResponseDto<GoalsDto> deleteGoals(@RequestParam Integer id){
        return goalsService.deleteGoals(id);
    }
}
