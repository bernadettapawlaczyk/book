package com.example.book.expection;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookDoesNotExistsCatalogue extends Exception{
    public BookDoesNotExistsCatalogue(String  title){
        super(title + "does not exist in catalogue");
    }
}
