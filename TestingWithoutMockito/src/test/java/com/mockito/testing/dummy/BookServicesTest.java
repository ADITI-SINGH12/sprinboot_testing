package com.mockito.testing.dummy;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServicesTest {
    @Test
    public void addBookTest(){
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        EmailServices emailServices = mock(EmailServices.class);
       BookServices bookServices = new BookServices(bookRepository,emailServices);
       Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
       Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
        Collection<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        when(bookRepository.findAll()).thenReturn(books);
        assertEquals(2, bookServices.findNumberOfBook());

    }
}
