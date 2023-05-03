package com.company.LibraryProject.service.validation;

import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ImageDto;
import com.company.LibraryProject.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ImageValidate {
    private final ImageRepository imageRepository;
    public List<ErrorDto> validate(ImageDto imageDto) {
       List<ErrorDto> errorDtoList=new ArrayList<>();
       if (imageRepository.existsByTokenAndDeletedAtIsNull(imageDto.getToken())){
           errorDtoList.add(new ErrorDto("Token","This is token already exist!"));
       }
        return errorDtoList;
    }
}
