package com.example.book.repository;

import com.example.book.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findById(Long aLong);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByEmail(String email);
    void saveAndFlush(User user);
}
