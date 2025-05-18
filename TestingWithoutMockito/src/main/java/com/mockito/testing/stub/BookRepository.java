package com.mockito.testing.stub;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);

}
