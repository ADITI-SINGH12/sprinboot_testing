package com.testing.fake;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FakeBookRepo implements BookRepository{
    HashMap<String,Book> bookList = new HashMap<>();
    @Override
    public void save(Book book) {
        bookList.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookList.values();
    }
}
