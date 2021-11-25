package com.example.book.service.impl;

import com.example.book.repository.OrderRepository;
import com.example.book.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }


    @Override
    public void save(Order order) {

    }

    @Override
    public Order getById(Long id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public void update(Order order) {
    }

    @Override
    public void delete(Long id) {

    }
}
