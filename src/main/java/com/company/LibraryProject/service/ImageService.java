package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Image;
import com.company.LibraryProject.repository.ImageRepository;
import com.company.LibraryProject.service.mapper.ImageMapper;
import com.company.LibraryProject.service.validation.ImageValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageValidation imageValidation;
    private final ImageMapper imageMapper;
    private final ImageRepository imageRepository;


    public ResponseDto<ImageDto> createImage(ImageDto dto) {
        try {
            Image image = imageMapper.toEntity(dto);
            image.setCreatedAt(LocalDateTime.now());
            imageRepository.save(image);
            return ResponseDto.<ImageDto>builder()
                    .data(imageMapper.toDto(image))
                    .success(true)
                    .message("Ok")
                    .code(0)
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .code(-3)
                    .message("Image %s saving error" + e.getMessage())
                    .success(false)
                    .data(dto)
                    .build();
        }
    }

    public ResponseDto<ImageDto> getImage(Integer imageId) {
        try {
            Optional<Image> optional = imageRepository.findByImageIdAndDeletedAtIsNull(imageId);
            if (optional.isEmpty()) {
                return ResponseDto.<ImageDto>builder()
                        .success(false)
                        .message("Image is not found")
                        .code(-1)
                        .build();
            }
            return ResponseDto.<ImageDto>builder()
                    .code(0)
                    .message("Ok")
                    .success(true)
                    .data(imageMapper.toDto(optional.get()))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .code(-3)
                    .message("Image %s saving error " + e.getMessage())
                    .success(false)
                    .build();
        }

    }

    public ResponseDto<ImageDto> updateImage(Integer imageId, ImageDto dto) {
        try {
            Optional<Image> optional = imageRepository.findByImageIdAndDeletedAtIsNull(imageId);
            if (optional.isEmpty()) {
                return ResponseDto.<ImageDto>builder()
                        .code(-1)
                        .message("Image is not found")
                        .success(false)
                        .build();
            }
            Image image = imageMapper.toEntity(dto);
            image.setImageId(optional.get().getImageId());
            image.setUpdatedAt(LocalDateTime.now());
            image.setCreatedAt(optional.get().getCreatedAt());
            imageRepository.save(image);
            return ResponseDto.<ImageDto>builder()
                    .success(true)
                    .message("ok")
                    .code(0)
                    .data(imageMapper.toDto(image))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .code(-3)
                    .message("Image %s saving error " + e.getMessage())
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<ImageDto> deleteImage(Integer imageId) {
        try {
            Optional<Image> optional = imageRepository.findByImageIdAndDeletedAtIsNull(imageId);
            if (optional.isEmpty()) {
                return ResponseDto.<ImageDto>builder()
                        .code(-1)
                        .message("Image is not found")
                        .success(false)
                        .build();
            }
            Image image = optional.get();
            image.setImageId(optional.get().getImageId());
            image.setUpdatedAt(optional.get().getUpdatedAt());
            image.setDeletedAt(LocalDateTime.now());
            image.setCreatedAt(optional.get().getCreatedAt());
            imageRepository.save(image);
            return ResponseDto.<ImageDto>builder()
                    .success(true)
                    .message("ok")
                    .code(0)
                    .data(imageMapper.toDto(image))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ImageDto>builder()
                    .code(-3)
                    .message("Image %s saving error " + e.getMessage())
                    .success(false)
                    .build();
        }
    }
}
