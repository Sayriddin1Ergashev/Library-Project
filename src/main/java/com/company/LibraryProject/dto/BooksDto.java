package com.company.LibraryProject.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooksDto {
    private Integer booksId;
    @NotBlank(message = "Name cannot be empty or null!")
    private String name;
    private AuthorDto authorDto;
    private Set<GoalsDto> goalsDto;
    private ImageDto imageDto;
    private PublisherDto publisherDto;
    @NotNull(message = "price cannot be null!")
    private Float price;
    @NotNull(message = "page cannot be null!")
    private Integer page;
    //@NotNull(message = "published cannot be null!")
    private LocalDate published;
    private OrdersBookDto ordersBooks;
    @NotNull(message = "amount cannot be null!")
    private Float amount;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
