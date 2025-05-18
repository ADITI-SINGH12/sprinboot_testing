package com.mockito.testing.fake;

public class BookServices {
    BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBooks(Book book){
        bookRepository.save(book);
    }
    public int findNumberOfBook(){
      return  bookRepository.findAll().size();
    }
}
