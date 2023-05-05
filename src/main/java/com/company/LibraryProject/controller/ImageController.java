package com.company.LibraryProject.controller;

import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.service.ImageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/create")
    public ResponseDto<ImageDto> createImage(@RequestBody ImageDto dto){
        return imageService.createImage(dto);
    }
    @GetMapping("/get/{imageId}")
    public ResponseDto<ImageDto> getImage(@PathVariable Integer imageId){
        return imageService.getImage(imageId);
    }
    @PutMapping("/update/{imageId}")
    public ResponseDto<ImageDto> updateImage(@PathVariable Integer imageId, @RequestBody ImageDto dto){
        return imageService.updateImage(imageId,dto);
    }
    @DeleteMapping("/delete/{imageId}")
    public ResponseDto<ImageDto> deleteImage(@PathVariable Integer imageId){
        return imageService.deleteImage(imageId);
    }



}
