package com.mockito.testing.stubbing;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);
     void save(Book book);
   Book findBookByBookId(String id);
}
