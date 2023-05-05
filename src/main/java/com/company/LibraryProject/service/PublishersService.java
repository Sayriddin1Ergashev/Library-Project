package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.PublishersDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Publisher;
import com.company.LibraryProject.repository.PublishersRepository;
import com.company.LibraryProject.service.mapper.PublishersMapper;
import com.company.LibraryProject.service.validation.PublishersValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublishersService {

    private final PublishersMapper publishersMapper;
    private final PublishersValidation publishersValidation;
    private final PublishersRepository publishersRepository;
    public ResponseDto<PublishersDto> createPublisher(PublishersDto dto) {
        try {
            Publisher publisher=publishersMapper.toEntity(dto);
            publisher.setCreatedAt(LocalDateTime.now());
            publishersRepository.save(publisher);
            return ResponseDto.<PublishersDto>builder()
                    .success(true)
                    .code(0)
                    .message("Ok")
                    .data(publishersMapper.toDto(publisher))
                    .build();
        }catch (Exception e){
            return ResponseDto.<PublishersDto>builder()
                    .message("Publishers saving error "+e.getMessage())
                    .code(-3)
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<PublishersDto> getPublisher(Integer id) {
        try {
            Optional<Publisher> optional=publishersRepository.findByPublisherIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<PublishersDto>builder()
                        .success(false)
                        .code(-1)
                        .message("Publishers %s is not found "+id)
                        .build();
            }
            return ResponseDto.<PublishersDto>builder()
                    .success(true)
                    .code(0)
                    .message("Ok")
                    .data(publishersMapper.toDto(optional.get()))
                    .build();
        }catch (Exception e){
            return ResponseDto.<PublishersDto>builder()
                    .message("Publishers saving error "+e.getMessage())
                    .code(-3)
                    .success(false)
                    .build();
        }    }

    public ResponseDto<PublishersDto> updatePublisher(PublishersDto dto, Integer id) {
        try {
            Optional<Publisher> optional=publishersRepository.findByPublisherIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<PublishersDto>builder()
                        .success(false)
                        .code(-1)
                        .message("Publishers %s is not found "+id)
                        .build();
            }
            Publisher publisher=publishersMapper.toEntity(dto);
            publisher.setUpdatedAt(LocalDateTime.now());
            publisher.setPublisherId(optional.get().getPublisherId());
            publisher.setCreatedAt(optional.get().getCreatedAt());
            publishersRepository.save(publisher);
            return ResponseDto.<PublishersDto>builder()
                    .success(true)
                    .code(0)
                    .message("Ok")
                    .data(publishersMapper.toDto(publisher))
                    .build();
        }catch (Exception e){
            return ResponseDto.<PublishersDto>builder()
                    .message("Publishers saving error "+e.getMessage())
                    .code(-3)
                    .success(false)
                    .build();
        }
    }

    public ResponseDto<PublishersDto> deletePublisher(Integer id) {

        try {
            Optional<Publisher> optional=publishersRepository.findByPublisherIdAndDeletedAtIsNull(id);
            if (optional.isEmpty()) {
                return ResponseDto.<PublishersDto>builder()
                        .success(false)
                        .code(-1)
                        .message("Publishers %s is not found "+id)
                        .build();
            }
            Publisher publisher= optional.get();
            publisher.setDeletedAt(LocalDateTime.now());
            publisher.setPublisherId(optional.get().getPublisherId());
            publisher.setCreatedAt(optional.get().getCreatedAt());
            publisher.setUpdatedAt(optional.get().getUpdatedAt());
            publishersRepository.save(publisher);
            return ResponseDto.<PublishersDto>builder()
                    .success(true)
                    .code(0)
                    .message("Ok")
                    .data(publishersMapper.toDto(publisher))
                    .build();
        }catch (Exception e){
            return ResponseDto.<PublishersDto>builder()
                    .message("Publishers saving error "+e.getMessage())
                    .code(-3)
                    .success(false)
                    .build();
        }
    }
}
