package com.mockito.testing.bdd.exceptionHandling;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);
     void save(Book book);
    List<Book> findAllBooks();
}
