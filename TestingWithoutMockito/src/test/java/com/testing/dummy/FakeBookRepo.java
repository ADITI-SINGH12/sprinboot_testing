package com.testing.dummy;

import com.testing.dummy.Book;
import com.testing.dummy.BookRepository;

import java.util.Collection;
import java.util.HashMap;

public class FakeBookRepo implements BookRepository {
    HashMap<String, Book> bookList = new HashMap<>();
    @Override
    public void save(Book book) {
        bookList.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookList.values();
    }
}
