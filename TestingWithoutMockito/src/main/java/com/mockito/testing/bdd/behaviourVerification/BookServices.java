package com.mockito.testing.bdd.behaviourVerification;

public class BookServices {
    BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void updatePrice(String bookId, int price){
     Book book = bookRepository.findBookById(bookId);
      book.setPrice(price);
      bookRepository.saveBook(book);
    }
}
