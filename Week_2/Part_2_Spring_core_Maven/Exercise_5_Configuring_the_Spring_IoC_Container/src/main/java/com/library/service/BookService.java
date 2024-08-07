package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void performService() {
        // Logic that uses bookRepository
        System.out.println("BookService is using " + bookRepository.getClass().getSimpleName());
    }
}
