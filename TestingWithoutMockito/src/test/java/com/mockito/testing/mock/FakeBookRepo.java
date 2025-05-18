package com.mockito.testing.mock;

import com.testing.mock.Book;
import com.testing.mock.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeBookRepo implements BookRepository {
//List<Book> bookList = new ArrayList<>();
    int savebook=0;
    Book lastSavedBook;
    @Override
    public void saveBook(Book book) {
       savebook++;
       lastSavedBook = book;
    }
   public void verify(Book book,int times){
        assertEquals(savebook,times);
        assertEquals(lastSavedBook,book);
   }
}
