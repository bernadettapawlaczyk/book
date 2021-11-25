package com.example.book.model;

public enum UserType {
    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum");

    private String name;

    UserType(String name) {
        this.name = name;
    }
}
