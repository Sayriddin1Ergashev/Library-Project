package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("orders_books"))
public class OrdersBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderBookId;
    private Integer ordersId;

    private Integer bookId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
