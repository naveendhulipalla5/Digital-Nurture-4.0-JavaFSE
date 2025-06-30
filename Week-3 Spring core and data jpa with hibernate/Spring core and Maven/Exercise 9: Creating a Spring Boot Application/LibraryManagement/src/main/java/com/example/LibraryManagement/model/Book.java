package com.example.LibraryManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Title is mandatory")
    private String title;
    
    @NotBlank(message = "Author is mandatory")
    private String author;
    
    @NotBlank(message = "ISBN is mandatory")
    private String isbn;
    
    @Min(1000) @Max(2100)
    private int publicationYear;
    
    // Default constructor (required by JPA)
    public Book() {}
    
    // All-args constructor
    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }
    
    // Getters and Setters (generate via IDE or manually)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { 
        this.publicationYear = publicationYear; 
    }
}