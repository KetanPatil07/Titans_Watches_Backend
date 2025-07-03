package com.titan.serviceipl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titan.entity.Order;
import com.titan.repo.OrderRepository;
import com.titan.service.OrderService;

@Service
public class Orderserviceimpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepo.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepo.save(order);
        }
        return null;
    }

    @Override
    public void deleteByid(Long id) {
        orderRepo.deleteById(id);
    }

    // ✅ New: Get orders by userId
    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepo.findByUserId(userId);
    }
}
