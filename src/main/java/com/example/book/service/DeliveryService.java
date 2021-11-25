package com.example.book.service;

import com.example.book.model.Delivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeliveryService {
    void save (Delivery delivery);
    Delivery getById (Long id);
    List<Delivery> getAll();
    void update(Delivery delivery);
    void delete(Long id);
}
