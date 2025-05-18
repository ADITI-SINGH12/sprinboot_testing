package com.mockito.testing.exception_handling;

public class DatabaseReadException extends RuntimeException{
    public DatabaseReadException(String message) {
        System.out.println(message);
        //super(message);
    }
}
