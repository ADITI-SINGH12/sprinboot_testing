package com.mockito.testing.stubbing;

import java.time.LocalDate;

public class BookRequest {
    String bookName;
    int price;
    LocalDate publishedDate;

    public BookRequest(String bookName,int price, LocalDate publishedDate) {

        this.bookName = bookName;
        this.price = price;
        this.publishedDate = publishedDate;
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
