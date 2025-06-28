package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showBook() {
        String book = bookRepository.getBookDetails();  // ✅ This method now exists
        System.out.println("Book: " + book);
    }
}
