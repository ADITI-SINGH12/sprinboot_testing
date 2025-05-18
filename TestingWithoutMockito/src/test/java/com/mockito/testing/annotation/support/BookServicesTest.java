package com.mockito.testing.annotation.support;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServicesTest {
    @Mock
    BookRepository bookRepository;
    //for class under test
    @InjectMocks
    BookServices bookServices;

    @Test
    public void addBookTest(){
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
