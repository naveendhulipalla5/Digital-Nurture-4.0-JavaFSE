package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private String message;                      // for constructor injection
    private BookRepository bookRepository;       // for setter injection

    // Constructor for message injection
    public BookService(String message) {
        this.message = message;
    }

    // Setter for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showBook() {
        System.out.println("Message: " + message);
        System.out.println("Book: " + bookRepository.getBookDetails());
    }
}
