package com.mockito.testing.exception_handling;

import java.sql.SQLException;
import java.util.List;

public class BookServices {

    private BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks() {
        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (Exception e) {
            // log exception
            throw new DatabaseReadException("Unable to read from database due to - " + e.getMessage());
        }
        int totalPrice = 0;
        for(Book book : books){
            totalPrice = totalPrice + book.getPrice();
        }
        return totalPrice;
    }

    public void addBook(Book book){
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            // log exception
            throw new DatabaseWriteException("Unable to write in database due to - " + e.getMessage());
        }
    }

}