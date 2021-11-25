package com.example.book.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void save(Order order);
    Order getById(Long id);
    List<Order> getAll();
    void update(Order order);
    void delete(Long id);
}
