package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/create")
    public ResponseDto<ImageDto> createImage(@Valid  @RequestBody ImageDto imageDto) {
        return this.imageService.create(imageDto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<ImageDto> getImage(@PathVariable(value = "id") Integer id) {
        return this.imageService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<ImageDto> updateImage(@PathVariable(value = "id") Integer id,@Valid @RequestBody ImageDto imageDto) {
        return this.imageService.update(id, imageDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<ImageDto> deleteImage(@PathVariable(value = "id") Integer id) {
        return this.imageService.delete(id);
    }

    @GetMapping("/get-all")
    public ResponseDto<List<ImageDto>> getAllImage() {
        return this.imageService.getAll();
    }
}
