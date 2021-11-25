package com.example.book.catalogue;

import com.example.book.expection.BookAlreadyExistsInCatalogueException;
import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddBookToCatalogue {
    private BookRepository bookRepository;

    public Book add(Book book) throws BookAlreadyExistsInCatalogueException{
        if(bookRepository.findByTitle(book.getTitle()).isPresent()){
            throw new BookAlreadyExistsInCatalogueException(book.getTitle());
        }
        return bookRepository.save(book);
    }
}
