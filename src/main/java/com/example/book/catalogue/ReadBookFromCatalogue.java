package com.example.book.catalogue;

import com.example.book.expection.BookDoesNotExistsCatalogue;
import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadBookFromCatalogue {
    private BookRepository bookRepository;

    public Book readByTitle(String title) throws Exception{
        return bookRepository.findByTitle(title)
                .orElseThrow(BookDoesNotExistsCatalogue::new);
    }
}
