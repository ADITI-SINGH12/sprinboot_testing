package com.mockito.testing.argument_matcher;

import java.time.LocalDate;
import java.util.List;

public class BookServices {

    private BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
        List<Book> newBooks = bookRepository.findNewBook(days);
        // 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450

        for(Book book : newBooks){
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);
        }

        return newBooks;
    }

    public int calculateTotalCost(List<String> bookIds) {
        int total = 0;
        for(String bookId : bookIds){
            Book book = bookRepository.findBookByBookId(bookId);
            total = total + book.getPrice();
        }
        return total;
    }

    public List<Book> addBook(List<Book> book) {
       return bookRepository.saveAll(book);
    }

    public void addBook(BookRequest bookRequest) {
        if(bookRequest.getPrice() <= 500){
            return;
        }
        Book book = new Book();
        book.setBookName(bookRequest.getBookName());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }
    public void updatePrice(String bookId,int updatedPrice){
        Book book = bookRepository.findBookByBookId(bookId);
        book.setPrice(updatedPrice);
        bookRepository.save(book);
    }
    public Book getBookByTitleAndPublishedDate(String title, LocalDate localDate) {
        return bookRepository.findBookByTitleAndPublishedDate(title, localDate);
    }

    public Book getBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital) {
        return bookRepository.findBookByTitleAndPriceAndIsDigital(title, price, isDigital);
    }

}