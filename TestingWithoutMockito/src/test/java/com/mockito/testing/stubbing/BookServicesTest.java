package com.mockito.testing.stubbing;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    @Test
    public void addBookTest(){
        List<String> bookIds = new ArrayList<>();
        bookIds.add("1234");
        bookIds.add("1235");
      Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
     Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());

        when(bookRepository.findBookByBookId("1234")).thenReturn(b1);
        when(bookRepository.findBookByBookId("1235")).thenReturn(b2);
        int actualCost = bookServices.calculateTotalCost(bookIds);
        assertEquals(900, actualCost);
    }
    /**
     * just for knowledge purpose
     * UnnecessaryStubbingException Before
     * In your previous test, you had something like this:
     * when(bookRepository.findBookByBookId("1234")).thenReturn(b1);
     * bookServices.addBook(b1); // ❌ This does NOT call findBookByBookId(...)
     * addBook(Book) only calls:
     * bookRepository.save(book);
     * So findBookByBookId(...) was never used, which is why Mockito said:
     * “Unnecessary stubbing detected.”
     **/
@Test
    public void MethodVoidTesting(){
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
        doNothing().when(bookRepository).save(b1); //this will perform equal method
    Book b2 = new Book("1235","JUnit in action",500, LocalDate.now());
    /**
     * misusing.PotentialStubbingProblem:
     * if we do this  bookServices.addBook(b2);
     **/
        bookServices.addBook(b1);
    }

    @Test
    public void MethodVoidEqualsTesting(){
    BookRequest bookRequest = new BookRequest("JUnit in action",600, LocalDate.now());
        Book b2 = new Book("1235","JUnit in action",600, LocalDate.now());
        /**
         *  if(bookRequest.getPrice() <= 500){
         *             return;
         *         }
         *  due to the above logic in book services class
         *     save method was not called from actual output i.e. addbook method
         *     that's why giving misusing PotentialStubbingProblem
         *     same occcurs if you change both the book price
         * **/
        doNothing().when(bookRepository).save(b2);
        bookServices.addBook(bookRequest);
    }
}
