package com.example.book.service;

import com.example.book.model.Copy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CopyService {
    public void save(Copy copy);
    public Copy getById(Long id);
    public List<Copy> getAll();
    public void update(Copy copy);
    public void delete(Long id);
}
