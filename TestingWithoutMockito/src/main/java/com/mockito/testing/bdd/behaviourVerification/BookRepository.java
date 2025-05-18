package com.mockito.testing.bdd.behaviourVerification;

public interface BookRepository {
   void saveBook(Book book);
   Book findBookById(String bookId);

}
