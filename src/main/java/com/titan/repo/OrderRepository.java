package com.titan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // ✅ Custom method to get all orders by userId
    List<Order> findByUserId(Long userId);
}
