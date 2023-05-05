package com.company.LibraryProject.dto;

import com.company.LibraryProject.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersDto {

    private Integer ordersId;
    private Integer userId;
    private User user;
    private Integer total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
