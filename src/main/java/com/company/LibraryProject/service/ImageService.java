package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Image;
import com.company.LibraryProject.repository.ImageRepository;
import com.company.LibraryProject.service.mapper.ImageMapper;
import com.company.LibraryProject.service.validation.ImageValidate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {
    private final ImageMapper imageMapper;
    private final ImageRepository imageRepository;
private final ImageValidate imageValidate;
    public ResponseDto<ImageDto> create(ImageDto imageDto) {
        List<ErrorDto>errors=this.imageValidate.validate(imageDto);
        if (!errors.isEmpty()){
            return ResponseDto.<ImageDto>builder()
                    .message("Validate error!")
                    .code(-2)
                    .success(false)
                    .data(imageDto)
                    .errors(errors)
                    .build();

        }
        try {
            Image image = imageMapper.toEntity(imageDto);
            image.setCreatedAt(LocalDateTime.now());
            this.imageRepository.save(image);
            log.info(String.format("This is image %d id successful created!", image.getImageId()));
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("This is image %d id successful created!", image.getImageId()))
                    .code(0)
                    .success(true)
                    .data(imageMapper.toDto(image))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("Image while saving error %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<ImageDto> get(Integer id) {
        Optional<Image> optional = imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("This is image %d id not found!", id))
                    .code(-1)
                    .build();
        }
        return ResponseDto.<ImageDto>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(imageMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<ImageDto> update(Integer id, ImageDto imageDto) {
        List<ErrorDto>errors=this.imageValidate.validate(imageDto);
        if (!errors.isEmpty()){
            return ResponseDto.<ImageDto>builder()
                    .message("Validate error!")
                    .code(-2)
                    .success(false)
                    .data(imageDto)
                    .errors(errors)
                    .build();

        }
        Optional<Image> optional = imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("This is image %d id not found!", id))
                    .code(-1)
                    .build();
        }
        try {
            Image image = imageMapper.toEntity(imageDto);
            image.setUpdatedAt(LocalDateTime.now());
            image.setCreatedAt(optional.get().getCreatedAt());
            image.setImageId(optional.get().getImageId());
            this.imageRepository.save(image);
            log.info(String.format("This is image %d id successful updated!",image.getImageId()));
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("This is image %d id successful updated!",image.getImageId()))
                    .code(0)
                    .success(true)
                    .data(imageMapper.toDto(image))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("Image while saving error %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<ImageDto> delete(Integer id) {
        Optional<Image> optional = imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("This is image %d id not found!", id))
                    .code(-1)
                    .build();
        }
        try {
            Image image = optional.get();
            image.setDeletedAt(LocalDateTime.now());
            this.imageRepository.save(image);
            log.info(String.format("This is image %d id successful deleted!", image.getImageId()));
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("This is image %d id successful deleted!", image.getImageId()))
                    .code(0)
                    .success(true)
                    .data(imageMapper.toDto(image))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .message(String.format("Image while saving error %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<List<ImageDto>> getAll() {
        return ResponseDto.<List<ImageDto>>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(this.imageRepository
                        .findAll()
                        .stream()
                        .map(this.imageMapper::toDto)
                        .toList())
                .build();
    }
}
