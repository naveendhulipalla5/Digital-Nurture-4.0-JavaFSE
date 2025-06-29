package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showBook() {
        System.out.println("Book: " + bookRepository.getBookDetails());
        System.out.println("Configuring the Spring IoC Container was successfull");
    }
}
