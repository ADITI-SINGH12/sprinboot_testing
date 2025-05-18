package com.mockito.testing.stubbing_a_spy;


import com.mockito.testing.stubing_a_spy.Book;
import com.mockito.testing.stubing_a_spy.BookManager;
import com.mockito.testing.stubing_a_spy.BookServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @InjectMocks
    BookManager bookManager;

    @Spy
    BookServices bookServices;

    @Test
    public void applyDiscountOnBookWithout_Spy_Annotation_Test(){
        BookServices bookServices1 = spy(BookServices.class);
       BookManager bookManager1 = new BookManager(bookServices1);
        Book b1 = new Book("1234","Mockito in action",400, LocalDate.now());
      int actualOutput = bookServices.getAppliedDiscount(b1,10);
      assertEquals(360,actualOutput);
    }

    @Test
    public void applyDiscountOnBookWith_Spy_Annotation_Test(){
        // We need to mock findBook because it is communicating to database or not implemented
        // We need to call getAppliedDiscount to calculate the discounted price
        Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        doReturn(book).when(bookServices).findBook("1234");
        /**
         * avoid using when().then because it calls actual output in that
         * case if there is any exception then it will throw error
         * **/
		//when(bookServices.findBook("1234")).thenReturn(book);
        int actualDiscount = bookManager.applyDiscountOnBook("1234", 10);
        assertEquals(450, actualDiscount);
    }
}
