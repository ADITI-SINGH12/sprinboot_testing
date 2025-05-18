package com.mockito.testing.bdd.behaviourVerification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
   BookServices bookServices;

    @Mock
    BookRepository bookRepository;

    /**
     * BDD works on the principle given when then
     * or AAA Arrange Act Assert
     * method name should also follow above principle
     * in giving method name so that
     * **/
    @Test
    public void test_Given_ABook_When_UpdatePriceIsCalledWithNewPrice_Then_BookPriceIsUpdated(){
        //given
        Book book1 = new Book("1234","Mockito in Action",400, LocalDate.now());
        given(bookRepository.findBookById("1234")).willReturn(book1);

        //when
        bookServices.updatePrice("1234",500);

        //then
        then(bookRepository).should().saveBook(book1);
    }
}
