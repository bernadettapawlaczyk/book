package com.example.book.repository;

import com.example.book.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Override
    Optional<Order> findById(Long aLong);
}
