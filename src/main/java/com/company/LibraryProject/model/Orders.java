package com.company.LibraryProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    private Integer total;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;


}
