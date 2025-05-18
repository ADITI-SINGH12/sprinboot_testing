package com.mockito.testing.behaviourVerification;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);
     void save(Book book);
   Book findBookByBookId(String id);
}
