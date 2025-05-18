package com.mockito.testing.argument_matcher;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository {
    List<Book> findNewBook(int days);
     void save(Book book);
   Book findBookByBookId(String id);

    Book findBookByTitleAndPublishedDate(String title, LocalDate localDate);

    Book findBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital);

    List<Book> saveAll(List<Book> book);
}
