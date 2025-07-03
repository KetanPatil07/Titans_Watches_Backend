package com.titan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.titan.entity.Order;

@Service
public interface OrderService {
    
    Order saveOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order updateOrderStatus(Long id, String status);

    void deleteByid(Long id);

    // ✅ New method to get orders for a specific user
    List<Order> getOrdersByUserId(Long userId);
}
