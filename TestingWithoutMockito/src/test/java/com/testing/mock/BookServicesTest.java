package com.testing.mock;

import com.testing.mock.Book;
import com.testing.mock.BookServices;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookServicesTest {

    @Test
    public void addBookTest(){
        FakeBookRepo fakebookRepository = new FakeBookRepo();
        BookServices bookServices = new BookServices(fakebookRepository);
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
        Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
        bookServices.addBook(b1);
        bookServices.addBook(b2);
     fakebookRepository.verify(b1,1);
    }
}
