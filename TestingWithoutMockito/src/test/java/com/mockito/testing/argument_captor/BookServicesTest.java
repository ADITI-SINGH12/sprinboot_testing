package com.mockito.testing.argument_captor;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServicesTest {
    @Mock
    BookRepository bookRepository;
    //for class under test
    @InjectMocks
    BookServices bookServices;

    @Captor
    ArgumentCaptor<Book> bookArgumentCaptor;
    /**
     * this will fail because there are 2 different object created for book
     * one is from book request in bookservice class
     * one is from verify function
     * **/
    @Test
    public void addBookTest(){
        BookRequest bookRequest = new BookRequest("Mockito in action",400,LocalDate.now());
       Book book = new Book("1234","Mockito in action",400,LocalDate.now());
       bookServices.addBook(bookRequest);
       verify(bookRepository).save(book);
    }

    @Test
    public void addBookTestusingArgumentCaptor(){
        BookRequest bookRequest = new BookRequest("Mockito in action",400,LocalDate.now());
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
        bookServices.addBook(bookRequest);
        verify(bookRepository).save(argumentCaptor.capture());
    }
    @Test
    public void addBookTestusing_AnnotationForArgumentCaptor(){
        BookRequest bookRequest = new BookRequest("Mockito in action",400,LocalDate.now());
         ArgumentCaptor.forClass(Book.class);
        bookServices.addBook(bookRequest);
        verify(bookRepository).save(bookArgumentCaptor.capture());
    }
}
