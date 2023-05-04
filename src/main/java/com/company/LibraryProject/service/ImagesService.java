package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ImagesDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Images;
import com.company.LibraryProject.repository.ImagesRepository;
import com.company.LibraryProject.service.mapper.ImagesMapper;
import com.company.LibraryProject.service.validation.ImagesValidate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImagesService {
    private final ImagesMapper imageMapper;
    private final ImagesRepository imageRepository;
    private final ImagesValidate imageValidate;
    public ResponseDto<ImagesDto> create(ImagesDto imagesDto) {
        List<ErrorDto> errors=this.imageValidate.validate(imagesDto);
        if (!errors.isEmpty()){
            return ResponseDto.<ImagesDto>builder()
                    .message("Validate error!")
                    .code(-2)
                    .success(false)
                    .data(imagesDto)
                    .errors(errors)
                    .build();

        }
        try {
            Images images = imageMapper.toEntity(imagesDto);
            images.setCreatedAt(LocalDateTime.now());
            this.imageRepository.save(images);
            log.info(String.format("This is image %d id successful created!", images.getImageId()));
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("This is image %d id successful created!", images.getImageId()))
                    .code(0)
                    .success(true)
                    .data(imageMapper.toDto(images))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("Image while saving error %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<ImagesDto> get(Integer id) {
        Optional<Images> optional = imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("This is image %d id not found!", id))
                    .code(-1)
                    .build();
        }
        return ResponseDto.<ImagesDto>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(imageMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<ImagesDto> update(Integer id, ImagesDto imageDto) {
        List<ErrorDto>errors=this.imageValidate.validate(imageDto);
        if (!errors.isEmpty()){
            return ResponseDto.<ImagesDto>builder()
                    .message("Validate error!")
                    .code(-2)
                    .success(false)
                    .data(imageDto)
                    .errors(errors)
                    .build();

        }
        Optional<Images> optional = imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("This is image %d id not found!", id))
                    .code(-1)
                    .build();
        }
        try {
            Images images = imageMapper.toEntity(imageDto);
            images.setUpdatedAt(LocalDateTime.now());
            images.setCreatedAt(optional.get().getCreatedAt());
            images.setImageId(optional.get().getImageId());
            this.imageRepository.save(images);
            log.info(String.format("This is image %d id successful updated!",images.getImageId()));
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("This is image %d id successful updated!",images.getImageId()))
                    .code(0)
                    .success(true)
                    .data(imageMapper.toDto(images))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("Image while saving error %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<ImagesDto> delete(Integer id) {
        Optional<Images> optional = imageRepository.findByImageIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("This is image %d id not found!", id))
                    .code(-1)
                    .build();
        }
        try {
            Images images = optional.get();
            images.setDeletedAt(LocalDateTime.now());
            this.imageRepository.save(images);
            log.info(String.format("This is image %d id successful deleted!", images.getImageId()));
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("This is image %d id successful deleted!", images.getImageId()))
                    .code(0)
                    .success(true)
                    .data(imageMapper.toDto(images))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImagesDto>builder()
                    .message(String.format("Image while saving error %s", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<List<ImagesDto>> getAll() {
        return ResponseDto.<List<ImagesDto>>builder()
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
