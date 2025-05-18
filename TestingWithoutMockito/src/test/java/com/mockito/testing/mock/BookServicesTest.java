package com.mockito.testing.mock;


import org.mockito.ArgumentCaptor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookServicesTest {

    @Test
    public void addBookTest(){
       BookRepository bookRepository = mock(BookRepository.class);
        BookServices bookServices = new BookServices(bookRepository);
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
        Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
        bookServices.addBook(b1);
        bookServices.addBook(b2);
        ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
//        verify(bookRepository, Mockito.times(1)).saveBook(b1);
//        verify(bookRepository, Mockito.times(1)).saveBook(b2);
        verify(bookRepository, Mockito.times(1)).saveBook(bookCaptor.capture());

    }
}
