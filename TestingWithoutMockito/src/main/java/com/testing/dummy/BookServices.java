package com.testing.dummy;

public class BookServices {
    BookRepository bookRepository;
    EmailServices emailServices;

    public BookServices(BookRepository bookRepository, EmailServices emailServices) {
        this.bookRepository = bookRepository;
        this.emailServices = emailServices;
    }

    public void addBooks(Book book){
        bookRepository.save(book);
    }
    public int findNumberOfBook(){
      return  bookRepository.findAll().size();
    }
}
