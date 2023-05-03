package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.ErrorDto;
import com.company.LibraryProject.dto.PublisherDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Publisher;
import com.company.LibraryProject.repository.PublisherRepository;
import com.company.LibraryProject.service.mapper.PublisherMapper;
import com.company.LibraryProject.service.validation.PublisherValidate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {
    private final PublisherMapper publisherMapper;
    private final PublisherRepository publisherRepository;
private final PublisherValidate publisherValidate;
    public ResponseDto<PublisherDto> create(PublisherDto publisherDto) {
        List<ErrorDto> errors=publisherValidate.validate(publisherDto);
        if (!errors.isEmpty()){
            return ResponseDto.<PublisherDto>builder()
                    .message("Validation error!")
                    .data(publisherDto)
                    .errors(errors)
                    .code(-2)
                    .build();
        }
        try {
            Publisher publisher = publisherMapper.toEntity(publisherDto);
            publisher.setCreatedAt(LocalDateTime.now());
            this.publisherRepository.save(publisher);
            log.info(String.format("This is ppublisher %d id successful created!", publisher.getPublisherId()));
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("This is ppublisher %d id successful created!", publisher.getPublisherId()))
                    .code(0)
                    .success(true)
                    .data(publisherMapper.toDto(publisher))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("Publisher while saving error %s ::", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<PublisherDto> get(Integer id) {
        Optional<Publisher> optional = this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("This is publisher %d id not found!",id))
                    .code(-1)
                    .build();
        }
        return ResponseDto.<PublisherDto>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(this.publisherMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<PublisherDto> update(Integer id, PublisherDto publisherDto) {
        List<ErrorDto> errors=publisherValidate.validate(publisherDto);
        if (!errors.isEmpty()){
            return ResponseDto.<PublisherDto>builder()
                    .message("Validation error!")
                    .data(publisherDto)
                    .errors(errors)
                    .code(-2)
                    .build();
        }
        Optional<Publisher> optional =publisherRepository.findByPublisherIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("This is publisher %d id not found!",id))
                    .code(-1)
                    .build();
        }
        try {
            Publisher publisher = this.publisherMapper.toEntity(publisherDto);
            publisher.setUpdatedAt(LocalDateTime.now());
            publisher.setPublisherId(optional.get().getPublisherId());
            publisher.setCreatedAt(optional.get().getCreatedAt());
            this.publisherRepository.save(publisher);
            log.info(String.format("This is publisher %d id successful updated!", publisher.getPublisherId()));
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("This is publisher %d id successful updated!", publisher.getPublisherId()))
                    .code(0)
                    .success(true)
                    .data(this.publisherMapper.toDto(publisher))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("Publisher while saving error %s ::", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<PublisherDto> delete(Integer id) {
        Optional<Publisher> optional = this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("This is publisher %d id not found!",id))
                    .code(-1)
                    .build();
        }
        try {
            Publisher publisher = optional.get();
            publisher.setDeletedAt(LocalDateTime.now());
            this.publisherRepository.save(publisher);
            log.info(String.format("This is publisher %d id successful deleted!", publisher.getPublisherId()));
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("This is publisher %d id successful deleted!", publisher.getPublisherId()))
                    .code(0)
                    .success(true)
                    .data(publisherMapper.toDto(publisher))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("Publisher while saving error %s ::", e.getMessage()))
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<List<PublisherDto>> getAll() {
        return ResponseDto.<List<PublisherDto>>builder()
                .message("Ok")
                .code(0)
                .success(true)
                .data(this.publisherRepository
                        .findAll()
                        .stream()
                        .map(this.publisherMapper::toDto)
                        .toList())
                .build();
    }
}
