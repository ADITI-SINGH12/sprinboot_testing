package com.mockito.testing.bdd.stubbing;

import java.util.List;

public interface BookRepository {
   void saveBook(Book book);
   Book findBookById(String bookId);

   List<Book> findNewBooks(int days);
}
