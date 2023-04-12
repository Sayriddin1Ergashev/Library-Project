package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.OrdersDto;
import com.company.LibraryProject.model.Orders;
import com.company.LibraryProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrdersMapper {

    private final UserMapper userMapper;
    private final UserService userService;

    public Orders toEntity(OrdersDto dto) {
        Orders orders = new Orders();
        orders.setOrdersId(dto.getOrdersId());
        orders.setTotal(dto.getTotal());
        orders.setUserId(dto.getUserId());
        orders.setUser(userMapper.toEntity(userService.getUser(dto.getUserId()).getData()));
        orders.setCreatedAt(dto.getCreatedAt());
        orders.setUpdatedAt(dto.getUpdatedAt());
        orders.setDeletedAt(dto.getDeletedAt());
        return orders;
    }

    public OrdersDto toDto(Orders orders) {
        OrdersDto dto = new OrdersDto();
        dto.setOrdersId(orders.getOrdersId());
        dto.setTotal(orders.getTotal());
        dto.setUserId(orders.getUserId());
        dto.setUser(orders.getUser());
        dto.setCreatedAt(orders.getCreatedAt());
        dto.setUpdatedAt(orders.getUpdatedAt());
        dto.setDeletedAt(orders.getDeletedAt());
        return dto;
    }
}
