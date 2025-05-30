package com.mockito.testing.mock;

public class BookServices {
    BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){
        if(book.getPrice() > 400){
            return;
        }
        bookRepository.saveBook(book);
    }
}
