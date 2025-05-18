package com.mockito.testing.annotation.support;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);

}
