package com.example.book.service.impl;

import com.example.book.model.Copy;
import com.example.book.repository.CopyRepository;
import com.example.book.service.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyServiceImpl implements CopyService {
    private CopyRepository copyRepository;

    @Override
    public void save(Copy copy) {
        copyRepository.save(copy);
    }

    @Override
    public Copy getById(Long id) {
        return copyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Copy> getAll() {
        List<Copy> copies = new LinkedList<>();
        copyRepository.findAll().iterator().forEachRemaining(copies::add);
        return copies;
    }

    @Override
    public void update(Copy copy) {
        copyRepository.save(copy);
    }

    @Override
    public void delete(Long id) {
        copyRepository.deleteById(id);
    }
}
