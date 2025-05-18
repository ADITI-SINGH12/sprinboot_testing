package com.mockito.testing.spy;

import com.testing.spy.Book;
import com.testing.spy.BookRepository;
import com.testing.spy.BookServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class BookServicesTest {

    @Test
    public void addBookTest(){
        BookRepository bookRepository = spy(BookRepository.class);
        BookServices bookServices = new BookServices(bookRepository);
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
        Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
        bookServices.addBook(b1);
        bookServices.addBook(b2);
        verify(bookRepository,times(1)).saveBook(b1);
        verify(bookRepository, Mockito.times(0)).saveBook(b2);
//        assertEquals(1,bookRepository.timesCalled());
//        assertFalse(bookRepository.calledWith(b2));
    }
}
