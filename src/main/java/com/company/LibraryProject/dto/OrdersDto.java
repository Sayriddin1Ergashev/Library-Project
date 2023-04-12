package com.company.LibraryProject.dto;

import com.company.LibraryProject.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrdersDto {
    private Integer ordersId;
    private Integer userId;
    private User user;
    private Integer total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
