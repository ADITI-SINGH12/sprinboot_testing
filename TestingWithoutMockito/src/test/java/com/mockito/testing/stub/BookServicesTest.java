package com.mockito.testing.stub;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServicesTest {

    //stubing without Annotation
    @Test
    public void addBookTest(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookServices bookServices = new BookServices(bookRepository);
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
       Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
      List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        when(bookRepository.findNewBook(7)).thenReturn(books);
       List<Book> bookList = bookServices.getNewBooksWithAppliedDiscount(10,7);
        assertEquals(2, bookList.size());
        assertEquals(360,bookList.get(0).getPrice());
        assertEquals(450,bookList.get(1).getPrice());
    }
}
