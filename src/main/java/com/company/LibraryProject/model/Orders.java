package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = ("orders"))
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("orders_id"))
    private Integer ordersId;
    @Column(name = ("user_id"))
    private Integer userId;
    private Integer total;

    @OneToMany(mappedBy = "ordersId", cascade = CascadeType.ALL)
    private Set<OrdersBook> ordersBooks;


    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;


}
