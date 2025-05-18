package com.testing.stubs;

import com.testing.stub.Book;
import com.testing.stub.BookRepository;
import com.testing.stub.BookServices;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServicesTest {
    @Test
    public void addBookTest(){
        BookRepository bookRepository = new FakeBookRepo();
        BookServices bookServices = new BookServices(bookRepository);
       List<Book> bookList = bookServices.getNewBooksWithAppliedDiscount(10,7);
        assertEquals(2, bookList.size());
        assertEquals(360,bookList.get(0).getPrice());
        assertEquals(450,bookList.get(1).getPrice());
    }
}
