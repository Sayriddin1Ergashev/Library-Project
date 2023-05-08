package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.ImagesDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.ImagesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("image")
public class ImagesController {
    private final ImagesService imagesService;

    @PostMapping("/create")
    public ResponseDto<ImagesDto> createImage(@Valid @RequestBody ImagesDto imagesDto) {
        return this.imagesService.create(imagesDto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<ImagesDto> getImage(@PathVariable(value = "id") Integer id) {
        return this.imagesService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<ImagesDto> updateImage(@PathVariable(value = "id") Integer id,
                                              @Valid @RequestBody ImagesDto imagesDto) {
        return this.imagesService.update(id, imagesDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<ImagesDto> deleteImage(@PathVariable(value = "id") Integer id) {
        return this.imagesService.delete(id);
    }

    @GetMapping("/get-all")
    public ResponseDto<List<ImagesDto>> getAllImage() {
        return this.imagesService.getAll();
    }
}
