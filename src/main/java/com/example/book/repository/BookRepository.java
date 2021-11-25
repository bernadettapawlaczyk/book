package com.example.book.repository;

import com.example.book.model.Book;
import com.example.book.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    Optional<Book> findById(Long aLong);
    Optional<Book> findByAuthor(String author);
    Optional<Book> findByTitle(String title);
    Optional<Book> findByGenre(Genre genre);

    Set<Book> findAllByGenre(Genre genre);
}
