package com.testing.mock;

import java.time.LocalDate;

public class Book {
    String bookId;
    String bookName;
   int price;
    LocalDate publishedDate;

    public Book(String bookId, String bookName,int price, LocalDate publishedDate) {
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
}
