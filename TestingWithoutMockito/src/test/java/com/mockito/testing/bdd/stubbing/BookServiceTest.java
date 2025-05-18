package com.mockito.testing.bdd.stubbing;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.BDDAssertions.then;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookServices bookServices;

    @Mock
    BookRepository bookRepository;

    @Test
    @DisplayName("Given - New books, When - Get new books with applied discount method is called, Then - New books with applied discount is returned")
    public void test_Given_NewBooks_When_getNewBooksWithAppliedDiscountIsCalled_Then_Newbookswithapplieddiscountisreturned(){
       //Given
        Book book1 = new Book("1234","Mockito in Action",500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);
        given(bookRepository.findNewBooks(7)).willReturn(newBooks);

        //when
        List<Book> newBooksWithAppliedDiscount= bookServices.getNewBooksWithAppliedDiscount(10,7);

        //then
        assertEquals(2, newBooksWithAppliedDiscount.size());
   	assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
	assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    /** then method applied
     * AssertJ - BDDAssertions
     * **/
        then(newBooksWithAppliedDiscount).isNotNull();
    then(newBooksWithAppliedDiscount.size()).isEqualTo(2);
        then(newBooksWithAppliedDiscount.get(0).getPrice()).isEqualTo(450);
        then(newBooksWithAppliedDiscount.get(1).getPrice()).isEqualTo(360);
    }
}
