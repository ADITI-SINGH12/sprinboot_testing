package com.testing.stub;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);

}
