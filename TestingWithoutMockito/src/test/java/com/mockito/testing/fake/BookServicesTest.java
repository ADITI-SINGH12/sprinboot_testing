package com.mockito.testing.fake;




import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServicesTest {
    @Test
    public void addBookTestWithMockito(){
        BookRepository bookRepository = mock(BookRepository.class);
       BookServices bookServices = new BookServices(bookRepository);
       Book b1 = new  Book("1234","Mockito in action",400, LocalDate.now());
       Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
       Collection<Book> bookCollection = new ArrayList<>();
        bookCollection.add(b1);
        bookCollection.add(b2);
        when(bookRepository.findAll()).thenReturn(bookCollection);
        assertEquals(2, bookServices.findNumberOfBook());
    }
}
