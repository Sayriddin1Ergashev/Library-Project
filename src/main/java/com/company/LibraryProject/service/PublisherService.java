package com.company.LibraryProject.service;

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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {
    private final PublisherMapper publisherMapper;
    private final PublisherValidate publisherValidate;
    private final PublisherRepository publisherRepository;


    public ResponseDto<PublisherDto> createPublisher(PublisherDto dto) {
        try {
            Publisher publisher = publisherMapper.toEntity(dto);
            publisher.setCreatedAt(LocalDateTime.now());
            publisherRepository.save(publisher);
            return ResponseDto.<PublisherDto>builder()
                    .success(true)
                    .code(0)
                    .message("This publisher successful created")
                    .data(publisherMapper.toDto(publisher))
                    .build();

        } catch (Exception e) {
            log.warn(String.format("Publisher saving error!") + e.getMessage());
            return ResponseDto.<PublisherDto>builder()
                    .message("Publisher %S id saving error" + dto.getPublisherId())
                    .code(-3)
                    .success(false)
                    .build();
        }


    }

    public ResponseDto<PublisherDto> getPublisher(Integer id) {
        try {
            Optional<Publisher> optional = publisherRepository.findByPublisherIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<PublisherDto>builder()
                        .message(String.format("This is publisher %d id is not found!", id))
                        .code(-1)
                        .success(false)
                        .build();
            }
            return ResponseDto.<PublisherDto>builder()
                    .data(publisherMapper.toDto(optional.get()))
                    .success(true)
                    .code(0)
                    .message("Ok")
                    .build();

        } catch (Exception e) {
            log.warn(String.format("Publisher saving error!") + e.getMessage());
            return ResponseDto.<PublisherDto>builder()
                    .message("Publisher saving error " + e.getMessage())
                    .code(-3)
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<PublisherDto> updatePublisher(PublisherDto dto, Integer id) {
        try {
            Optional<Publisher> optional = publisherRepository.findByPublisherIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<PublisherDto>builder()
                        .message(String.format("This is publisher %d id is not found!", id))
                        .code(-1)
                        .success(false)
                        .build();
            }
            Publisher publisher = publisherMapper.toEntity(dto);
            publisher.setPublisherId(optional.get().getPublisherId());
            publisher.setCreatedAt(optional.get().getCreatedAt());
            publisher.setUpdatedAt(LocalDateTime.now());
            publisherRepository.save(publisher);
            return ResponseDto.<PublisherDto>builder()
                    .data(publisherMapper.toDto(publisher))
                    .success(true)
                    .code(0)
                    .message("Successful updated!")
                    .build();

        } catch (Exception e) {
            log.warn(String.format("Publisher saving error!") + e.getMessage());
            return ResponseDto.<PublisherDto>builder()
                    .message("Publisher saving error " + e.getMessage())
                    .code(-3)
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<PublisherDto> deletePublisher(Integer id) {
        try {
            Optional<Publisher> optional = publisherRepository.findByPublisherIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<PublisherDto>builder()
                        .message(String.format("This is publisher %d id is not found!", id))
                        .code(-1)
                        .success(false)
                        .build();
            }
            Publisher publisher = optional.get();
            publisher.setDeletedAt(LocalDateTime.now());
            publisherRepository.save(publisher);
            return ResponseDto.<PublisherDto>builder()
                    .data(publisherMapper.toDto(publisher))
                    .success(true)
                    .code(0)
                    .message("Successful deleted!")
                    .build();

        } catch (Exception e) {
            log.warn(String.format("Publisher saving error!") + e.getMessage());
            return ResponseDto.<PublisherDto>builder()
                    .message("Publisher saving error " + e.getMessage())
                    .code(-3)
                    .success(false)
                    .build();
        }
    }
}
