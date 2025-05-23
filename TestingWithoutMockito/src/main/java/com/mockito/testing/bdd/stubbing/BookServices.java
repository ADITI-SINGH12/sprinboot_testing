package com.mockito.testing.bdd.stubbing;

import java.util.List;

public class BookServices {
    BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
        List<Book> newBooks = bookRepository.findNewBooks(days);
        // 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450

        for(Book book : newBooks){
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);
        }

        return newBooks;
    }
}
