package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.model.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public interface BookService {
    void save (Book book);
    Book getById(Long id);
    List<Book> getAll();
    void update(Book book);
    void delete(Long id);
    Book findByTitle(String Title);
    Book findByGenre(Genre genre);
    Set<Book> findAllByGenre(Genre genre);
}
