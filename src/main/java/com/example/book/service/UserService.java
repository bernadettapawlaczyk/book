package com.example.book.service;

import com.example.book.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void save(User user);
    User getById(Long id);
    List<User> getAll();
    void update(User user);
    void delete(Long id);
    User findByEmail(String email);
}
