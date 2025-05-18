package com.testing.stubs;

import com.testing.stub.Book;
import com.testing.stub.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FakeBookRepo implements BookRepository {
List<Book> bookList = new ArrayList<>();
    @Override
    public List<Book> findNewBook(int days) {
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
       Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
        bookList.add(b1);
        bookList.add(b2);
        return bookList;
    }
}
