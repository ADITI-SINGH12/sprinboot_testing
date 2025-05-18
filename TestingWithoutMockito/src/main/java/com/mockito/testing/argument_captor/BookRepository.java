package com.mockito.testing.argument_captor;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);
     void save(Book book);
   Book findBookByBookId(String id);
}
