package com.testing.stub;

import java.util.List;

public class BookServices {
    BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
       List<Book> books = bookRepository.findNewBook(days);
       for(Book b: books){
           int price = b.getPrice();
           price = price- (discountRate*price)/100;
           b.setPrice(price);
       }
       return books;
    }
}
