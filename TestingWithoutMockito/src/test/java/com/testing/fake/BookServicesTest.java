package com.testing.fake;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

public class BookServicesTest {
    @Test
    public void addBookTest(){
        BookRepository bookRepository = new FakeBookRepo();
        BookServices bookServices = new BookServices(bookRepository);
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
        Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
        bookServices.addBooks(b1);
        bookServices.addBooks(b2);
        assertEquals(2, bookServices.findNumberOfBook());
    }
}
