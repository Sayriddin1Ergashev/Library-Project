package com.company.LibraryProject.service.validation;

import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.ImagesDto;
import com.company.LibraryProject.dto.PublisherDto;
import com.company.LibraryProject.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PublisherValidate {
    private final PublisherRepository publisherRepository;
    public List<ErrorDto> validate(PublisherDto publisherDto) {
        List<ErrorDto> errors = new ArrayList<>();



        return errors;
    }
}
