package com.testing.dummy;

import com.testing.dummy.Book;
import com.testing.dummy.BookRepository;
import com.testing.dummy.BookServices;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookServicesTest {
    @Test
    public void addBookTest(){
        BookRepository bookRepository = new FakeBookRepo();
        EmailServices emailServices = new DummyEmailService();
       BookServices bookServices = new BookServices(bookRepository,emailServices);
       Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
       Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
        bookServices.addBooks(b1);
        bookServices.addBooks(b2);
        assertEquals(2, bookServices.findNumberOfBook());

    }
}
