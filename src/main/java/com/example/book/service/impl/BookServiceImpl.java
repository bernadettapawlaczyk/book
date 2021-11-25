package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.model.Genre;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }
    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public Book getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new LinkedList<>();
        repository.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public void update(Book book) {
        repository.save(book);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Book findByTitle(String Title) {
        return repository.findByTitle(Title).orElse(null);
    }

    @Override
    public Book findByGenre(Genre genre) {
        return repository.findByGenre(genre).orElse(null);
    }

    @Override
    public Set<Book> findAllByGenre(Genre genre) {
        return repository.findAllByGenre(genre);
    }
}
