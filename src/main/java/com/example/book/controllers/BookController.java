package com.example.book.controllers;

import com.example.book.model.Book;
import com.example.book.model.Genre;
import com.example.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;

@Slf4j
@Controller
public class BookController {
    private final BookService service;

    public BookController(@Qualifier("bookServiceImpl") final BookService service) {
        this.service = service;
    }

    @GetMapping({"/books"})
    public String getBookIndex(Model model) {
        model.addAttribute("books", service.getAll());
        return "books/index";
    }

    @GetMapping({"/books/action"})
    public String getAction(Model model) {
        model.addAttribute("genre", Genre.ACTION);
        model.addAttribute("books", service.findAllByGenre(Genre.ACTION));
        return "books/action";
    }


    @RequestMapping(value="/books/action/delete")
    public String deleteBook(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/books/action";

    }
    @RequestMapping(value="/books/delete")
    public String deleteBookFromAll(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/books";

    }
    @GetMapping({"/books/horror"})
    public String getHorror(Model model) {
        model.addAttribute("genre", Genre.HORROR);
        model.addAttribute("books", service.findAllByGenre(Genre.HORROR));
        return "books/horror";
    }


    @RequestMapping(value="/books/horror/delete")
    public String deleteHorror(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/books/horror";

    }
    @GetMapping({"/books/documentary"})
    public String getDocumentary(Model model) {
        model.addAttribute("genre", Genre.DOCUMENTARY);
        model.addAttribute("books", service.findAllByGenre(Genre.DOCUMENTARY));
        return "books/documentary";
    }


    @RequestMapping(value="/books/documentary/delete")
    public String deleteDocumentary(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/books/documentary";

    }
    @GetMapping({"/books/scifi"})
    public String getSciFi(Model model) {
        model.addAttribute("genre", Genre.SCI_FI);
        model.addAttribute("books", service.findAllByGenre(Genre.SCI_FI));
        return "books/scifi";
    }


    @RequestMapping(value="/books/scifi/delete")
    public String deleteSciFi(@RequestParam Long id , Model model) {

        service.delete(id);
        return "redirect:/books/scifi";

    }
    @GetMapping("/book")
    public String getOneWorker(@RequestParam Long id, Model model) {

        model.addAttribute("book",service.getById(id));

        return "bookb/book";

    }

    @GetMapping("/add-book")
    public String newMovie(Model model) {
        model.addAttribute("genre", new LinkedList<Genre>(Arrays.asList(Genre.values())));
        model.addAttribute("movie", new Book());
        return "books/add-book";
    }

    @PostMapping("/save-book")
    public String saveMovie(@ModelAttribute Book book) {
        service.save(book);
        log.info("Added movie: " + book);

        return "redirect:/books";
    }
}
