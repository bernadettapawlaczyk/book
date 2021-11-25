package com.example.book.expection;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookAlreadyExistsInCatalogueException extends Exception{
    public BookAlreadyExistsInCatalogueException (String title){
        super(title + " Arleady exists in catalogue");
    }
}
