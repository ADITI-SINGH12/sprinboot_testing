package com.mockito.testing.argument_matcher;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.StartsWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookServices bookServices;

    @Mock
    BookRepository bookRepository;

    //Any String -- matcher
    @Test
    public void testUpdatedPrice(){
        Book book = new Book("1234","Mockito in Action",500,LocalDate.now());
        when(bookRepository.findBookByBookId(anyString())).thenReturn(book);
        bookServices.updatePrice("1234",400);
        verify(bookRepository).save(book);
    }
    // Argument Matchers should be provided for all arguments
    // Argument Matchers cant be used outside stubbing/verification
    @Test
    public void invalidUseOfArgument(){
        Book book = new Book("1234","Mockito in Action",500,LocalDate.now());
        when(bookRepository.findBookByTitleAndPublishedDate(eq("Mockito in Action"),any())).
                thenReturn(book);
        Book actualBook =  bookServices.getBookByTitleAndPublishedDate("Mockito in Action",LocalDate.now());
        assertEquals("Mockito in Action",actualBook.bookName);
    }
    @Test
    public void testSpecificTypeOfArgumentMatchers(){
        Book book = new Book("1234","Mockito in Action",500,LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(eq("Mockito in Action"),anyInt(),anyBoolean())).
                thenReturn(book);
        Book actualBook =  bookServices.getBookByTitleAndPriceAndIsDigital("Mockito in Action",120,true);
        assertEquals("Mockito in Action",actualBook.bookName);
    }

    @Test
    public void testCollectionTypeOfArgumentMatchers(){
        Book book = new Book("1234","Mockito in Action",500,LocalDate.now());
        Book book1 = new Book("1235","junit in Action",500,LocalDate.now());
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        when(bookRepository.saveAll(anyList())).thenReturn(books);
        List<Book> newBooks = bookServices.addBook(books);
        assertEquals(books.size(),newBooks.size());
        verify(bookRepository).saveAll(anyList()); // anySet, anyMap, anyCollection
    }

    @Test
    public void testStringTypeOfArgumentMatchers(){
        Book book = new Book("1234","Mockito in Action",500,LocalDate.now());
      /**  when(bookRepository.findBookByTitleAndPriceAndIsDigital(startsWith("Mockito"),anyInt(),anyBoolean())).
                thenReturn(book); **/
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(contains("in"),anyInt(),anyBoolean())).
                thenReturn(book);
        Book actualBook =  bookServices.getBookByTitleAndPriceAndIsDigital("Mockito in Action",120,true);
        assertEquals("Mockito in Action",actualBook.bookName);
    }
}
