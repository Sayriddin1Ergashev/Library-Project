package com.company.LibraryProject.repository;

import com.company.LibraryProject.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Optional<Orders> findByOrdersIdAndDeletedAtIsNull(Integer ordersId);
}
