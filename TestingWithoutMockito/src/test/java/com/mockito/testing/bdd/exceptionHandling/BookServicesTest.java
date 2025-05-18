package com.mockito.testing.bdd.exceptionHandling;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

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
        //given
       Book book = new Book("1234","Mockito in Action",120,LocalDate.now());
        given(bookRepository.findAllBooks()).willThrow(DatabaseReadException.class);
        //when
        bookServices.getTotalPriceOfBooks();
        assertThrows(DatabaseReadException.class,()->bookServices.getTotalPriceOfBooks());
    }
}
