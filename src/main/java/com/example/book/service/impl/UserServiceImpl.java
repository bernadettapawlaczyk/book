package com.example.book.service.impl;

import com.example.book.model.User;
import com.example.book.repository.UserRepository;
import com.example.book.service.UserService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        List<User> users = new LinkedList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public void update(User user) {
        userRepository.save(user);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
