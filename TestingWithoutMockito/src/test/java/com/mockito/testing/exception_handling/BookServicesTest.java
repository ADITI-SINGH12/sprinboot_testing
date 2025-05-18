package com.mockito.testing.exception_handling;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServicesTest {
    @Mock
    BookRepository bookRepository;
    //for class under test
    @InjectMocks
    BookServices bookServices;

    /**
     * Exception handling with void method
     * **/
    @Test
    public void addBookTest(){
        Book book = new Book("1234","Mockito in Action",120,LocalDate.now());
        doThrow(DatabaseWriteException.class).when(bookRepository).save(book);
        assertThrows(DatabaseWriteException.class,()->bookServices.addBook(book));
    }

    /**
     * Exception handling with non-void method
     * **/
    @Test
    public void getTotalPriceOfBooksTest(){
        Book book = new Book("1234","Mockito in Action",120,LocalDate.now());
        when(bookRepository.findAllBooks()).thenThrow(DatabaseReadException.class);
        assertThrows(DatabaseReadException.class,()->bookServices.getTotalPriceOfBooks());
    }
}
