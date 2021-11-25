package com.example.book;

import com.example.book.model.Book;
import com.example.book.model.Genre;
import com.example.book.repository.BookRepository;
import com.example.book.repository.CopyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    private CopyRepository copyRepository;

    private static Long expectedId;

    @BeforeAll
    public static void init(){
        expectedId = 1L;
    }

    @Test
    public void find_book_by_genre(){
        //given
        Genre gatunekFilmu = Genre.ACTION;
        String title = "Demony wojny";

        Book book1 = new Book();
        book1.setTitle(title);
        book1.setGenre(gatunekFilmu);

        Set<Book> foundBooksList = bookRepository.findAllByGenre(gatunekFilmu);
        Assertions.assertThat(foundBooksList.isEmpty()).isTrue();

        //when
        bookRepository.save(book1);
        foundBooksList = bookRepository.findAllByGenre(gatunekFilmu);

        //then
        Assertions.assertThat(foundBooksList.isEmpty()).isFalse();
        Assertions.assertThat(foundBooksList.size()).isEqualTo(1);

        //TO DO

    }
}
