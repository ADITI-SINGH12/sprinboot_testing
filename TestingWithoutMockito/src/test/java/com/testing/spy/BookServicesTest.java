package com.testing.spy;

import com.testing.spy.Book;
import com.testing.spy.BookRepository;
import com.testing.spy.BookServices;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookServicesTest {

    @Test
    public void addBookTest(){
        FakeBookRepo bookRepository = new FakeBookRepo();
        BookServices bookServices = new BookServices(bookRepository);
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
        Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
        bookServices.addBook(b1);
        bookServices.addBook(b2);
        assertEquals(1,bookRepository.timesCalled());
        assertFalse(bookRepository.calledWith(b2));
    }
}
