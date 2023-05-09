package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.PublishersDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.PublishersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("publishers")
public class PublishersController {
    private final PublishersService publishersService;

    @PostMapping("/create")
    public ResponseDto<PublishersDto> createPublisher(@Valid @RequestBody PublishersDto dto){
        return publishersService.createPublisher(dto);
    }
    @GetMapping("/get/{id}")
    public ResponseDto<PublishersDto> getPublisher(@PathVariable Integer id){
        return publishersService.getPublisher(id);
    }
    @PutMapping("/update/{id}")
    public ResponseDto<PublishersDto> updatePublisher(@Valid @RequestBody PublishersDto dto, @PathVariable Integer id){
        return publishersService.updatePublisher(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<PublishersDto> deletePublisher(@PathVariable Integer id) {
        return publishersService.deletePublisher(id);
    }
}
