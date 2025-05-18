package com.mockito.testing.stubing_a_spy;

public class BookManager {

    private BookServices bookService;

    public BookManager(BookServices bookService) {
        this.bookService = bookService;
    }

    /**
     * Spy testing is used when you have dependency on 2 method
     * then one is used as mock and other one used as actual call
     * **/
    public int applyDiscountOnBook(String bookId, int discountRate) {
        Book book = bookService.findBook(bookId); // We need to Mock
        int discountedPrice = bookService.getAppliedDiscount(book, discountRate);
        return discountedPrice;
    }
}
