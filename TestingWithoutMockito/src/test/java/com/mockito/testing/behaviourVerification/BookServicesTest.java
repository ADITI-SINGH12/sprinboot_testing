package com.mockito.testing.behaviourVerification;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServicesTest {
    @Mock
    BookRepository bookRepository;
    //for class under test
    @InjectMocks
    BookServices bookServices;

    //verify to check that correct object is saved or not but if we removes equal from
    //Book class then it can through error "Argument(s) are different! Wanted:"
    @Test
    public void verifyBookBehaviour(){
        BookRequest bookRequest = new BookRequest("Mockito in action",600,LocalDate.now());
        Book book = new Book("1234","Mockito in action",600,LocalDate.now());
        bookServices.addBook(bookRequest);
        verify(bookRepository).save(book);
    }

    //verifying no of interaction
    @Test
    public void verifyBookBehaviourNoOfTimes(){
        BookRequest bookRequest = new BookRequest("Mockito in action",600,LocalDate.now());
        Book book = new Book("1234","Mockito in action",600,LocalDate.now());
        bookServices.addBook(bookRequest);
        verify(bookRepository,times(1)).save(book);
    }

    //verify interaction has occured or not
    @Test
    public void verifyBookBehaviouroccuredOrNot(){
        BookRequest bookRequest = new BookRequest("Mockito in action",500,LocalDate.now());
        Book book = new Book("1234","Mockito in action",600,LocalDate.now());
        bookServices.addBook(bookRequest);
        verify(bookRepository,never()).save(book);
    }

    //verify no interaction wass made
    //if due to some reason operation not performed and returned from the method then this can be used
    @Test
    public void verifyBookBehaviournotoccured(){
        bookServices.updatePrice(null,600);
        verifyNoInteractions(bookRepository);
    }

    /**
     * verifyNoMoreInteractions(...)
     * Use Case: "I want to make sure no extra calls were made to this mock."
      **/
    @Test
    public void noMoreInteractionForVerification(){
        BookRequest bookRequest = new BookRequest("Mockito in action",500,LocalDate.now());
        Book book = new Book("1234","Mockito in action",500,LocalDate.now());
        when(bookRepository.findBookByBookId("1234")).thenReturn(book);
        bookServices.updatePrice("1234",400);
       verify(bookRepository).findBookByBookId("1234");
       verifyNoMoreInteractions(bookRepository);
        // verify(bookRepository).save(book);
        /**
         * If above activates then throw error of No interaction invokked
         * **/
    }

    //verify order of interaction
    @Test
    public void OrderOfInteractionForVerification(){
        Book book = new Book("1234","Mockito in action",500,LocalDate.now());
        when(bookRepository.findBookByBookId("1234")).thenReturn(book);
        bookServices.updatePrice("1234",400);
        InOrder inorder = Mockito.inOrder(bookRepository);
//        inorder.verify(bookRepository).save(book);
//        inorder.verify(bookRepository).findBookByBookId("1234");
        /**The above commented line will fail the TC
         *  because the actual call order would not match your expectation.
         *  **/
        inorder.verify(bookRepository).findBookByBookId("1234");
        inorder.verify(bookRepository).save(book);
}

//verify no of interaction has occurred certain times
    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice3() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
        bookServices.addBook(bookRequest);
        bookServices.addBook(bookRequest);
        bookServices.addBook(bookRequest);
//		verify(bookRepository, times(2)).save(book);
//		verify(bookRepository, atLeast(4)).save(book);
//		verify(bookRepository, atMost(2)).save(book);
//		verify(bookRepository, atMostOnce()).save(book);
        verify(bookRepository, atLeastOnce()).save(book);
    }
}
