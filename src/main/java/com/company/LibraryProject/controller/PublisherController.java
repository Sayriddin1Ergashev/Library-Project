package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.PublisherDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.PublisherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("publisher")
public class PublisherController {
    private final PublisherService publisherService;

    @PostMapping("/create")
    public ResponseDto<PublisherDto> createPublisher(@Valid @RequestBody PublisherDto publisherDto) {
        return this.publisherService.create(publisherDto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<PublisherDto> getPublisher(@PathVariable(value = "id") Integer id) {
        return this.publisherService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<PublisherDto> updatePublisher(@Valid @RequestBody PublisherDto publisherDto, @PathVariable(value = "id") Integer id) {
        return this.publisherService.update(id, publisherDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<PublisherDto> deletePublisher(@PathVariable(value = "id") Integer id) {
        return this.publisherService.delete(id);
    }

    @GetMapping("/get-all")
    public ResponseDto<List<PublisherDto>> getAllPublisher() {
        return this.publisherService.getAll();
    }
}
