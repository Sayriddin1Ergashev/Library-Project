package com.company.LibraryProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersDto {
    private Integer ordersId;
    private Integer userId;
    private UserDto userDto;
    private Set<OrdersBookDto> ordersBooksDto;
  //  @NotBlank(message = "Total cannot be empty or null!")
    private Integer total;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;





}
