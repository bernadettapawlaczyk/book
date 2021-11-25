package com.example.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    @Enumerated
    private Genre genre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private String description;

    /*@OneToMany(cascade = CascadeType.ALL,mappedBy = "movie",fetch = FetchType.EAGER)
    private Set<Copy> copies = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie",fetch = FetchType.EAGER)
    private Set<Opinion> opinions  = new HashSet<>();

     */
}
