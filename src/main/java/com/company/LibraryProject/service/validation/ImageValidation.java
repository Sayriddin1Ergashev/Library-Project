package com.company.LibraryProject.service.validation;

import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ImageValidation {

    public  List<ErrorDto> validation(ImageDto dto){
        List<ErrorDto> errors=new ArrayList<>();


        return errors;
    }
}
