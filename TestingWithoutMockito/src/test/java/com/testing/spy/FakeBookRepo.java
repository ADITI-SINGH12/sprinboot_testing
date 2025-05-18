package com.testing.spy;

import com.testing.spy.Book;
import com.testing.spy.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeBookRepo implements BookRepository {
//List<Book> bookList = new ArrayList<>();
    int savebook=0;
    Book lastSavedBook;
    @Override
    public void saveBook(Book book) {
       savebook++;
       lastSavedBook = book;
    }
    public Boolean calledWith(Book book){
        return lastSavedBook.equals(book);
    }
    public int timesCalled(){
        return savebook;
    }
}
