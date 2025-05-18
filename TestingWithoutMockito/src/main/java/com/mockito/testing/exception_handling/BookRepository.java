package com.mockito.testing.exception_handling;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);
     void save(Book book);
    List<Book> findAllBooks();
}
