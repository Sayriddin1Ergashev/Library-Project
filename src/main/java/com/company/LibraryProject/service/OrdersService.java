package com.company.LibraryProject.service;

import com.company.LibraryProject.dto.OrdersDto;
import com.company.LibraryProject.dto.ResponseDto;
import com.company.LibraryProject.model.Orders;
import com.company.LibraryProject.repository.OrdersRepository;
import com.company.LibraryProject.service.mapper.OrdersMapper;
import com.company.LibraryProject.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;
    private final UserService userService;

    public ResponseDto<OrdersDto> create(OrdersDto ordersDto) {
        if (userService.getUser(ordersDto.getUserId()).getData() == null) {
            return ResponseDto.<OrdersDto>builder()
                    .message(userService.getUser(ordersDto.getUserId()).getMessage())
                    .code(-3)
                    .build();
        }
        try {
            Orders orders = ordersMapper.toEntity(ordersDto);
            orders.setCreatedAt(LocalDateTime.now());
            ordersRepository.save(orders);
            return ResponseDto.<OrdersDto>builder()
                    .success(true)
                    .message("OK")
                    .data(ordersMapper.toDto(orders))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<OrdersDto>builder()
                    .message(String.format("Orders while saving error :: %s", e.getMessage()))
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<OrdersDto> get(Integer ordersId) {
        Optional<Orders> optional = ordersRepository.findByOrdersIdAndDeletedAtIsNull(ordersId);
        if (optional.isEmpty()) {
            return ResponseDto.<OrdersDto>builder()
                    .message("Orders is not found!")
                    .code(-1)
                    .build();
        }
        return ResponseDto.<OrdersDto>builder()
                .success(true)
                .message("OK")
                .data(ordersMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<OrdersDto> update(Integer ordersId, OrdersDto ordersDto) {
        if (userService.getUser(ordersDto.getUserId()).getData() == null) {
            return ResponseDto.<OrdersDto>builder()
                    .message(userService.getUser(ordersDto.getUserId()).getMessage())
                    .code(-3)
                    .build();
        }
        try { Optional<Orders> optional = ordersRepository.findByOrdersIdAndDeletedAtIsNull(ordersId);
            if (optional.isEmpty()) {
                return ResponseDto.<OrdersDto>builder()
                        .message("Orders is not found!")
                        .code(-1)
                        .build();
            }
            Orders orders = ordersMapper.toEntity(ordersDto);
            orders.setUpdatedAt(LocalDateTime.now());
            orders.setOrdersId(optional.get().getOrdersId());
            orders.setCreatedAt(optional.get().getCreatedAt());
            ordersRepository.save(orders);
            return ResponseDto.<OrdersDto>builder()
                    .success(true)
                    .message("OK")
                    .data(ordersMapper.toDto(orders))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<OrdersDto>builder()
                    .message(String.format("Orders while saving error :: %s", e.getMessage()))
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<OrdersDto> delete(Integer ordersId) {
        try { Optional<Orders> optional = ordersRepository.findByOrdersIdAndDeletedAtIsNull(ordersId);
            if (optional.isEmpty()) {
                return ResponseDto.<OrdersDto>builder()
                        .message("Orders is not found!")
                        .code(-1)
                        .build();
            }
            Orders orders = optional.get();
            orders.setDeletedAt(LocalDateTime.now());
            orders.setUpdatedAt(optional.get().getUpdatedAt());
            orders.setOrdersId(optional.get().getOrdersId());
            orders.setCreatedAt(optional.get().getCreatedAt());
            ordersRepository.save(orders);
            return ResponseDto.<OrdersDto>builder()
                    .success(true)
                    .message("OK")
                    .data(ordersMapper.toDto(orders))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<OrdersDto>builder()
                    .message(String.format("Orders while saving error :: %s", e.getMessage()))
                    .code(-1)
                    .build();
        }

    }

    public ResponseDto<List<OrdersDto>> getAll() {
        return null;
    }
}
