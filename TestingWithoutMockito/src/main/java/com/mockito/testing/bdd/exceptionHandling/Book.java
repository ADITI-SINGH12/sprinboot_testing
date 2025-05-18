package com.mockito.testing.bdd.exceptionHandling;

import java.time.LocalDate;
import java.util.Objects;



public class Book {
    String bookId;
    String bookName;
   int price;
    LocalDate publishedDate;

    public Book() {
    }

    public Book(String bookId, String bookName, int price, LocalDate publishedDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(publishedDate, book.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, price, publishedDate);
    }
}
