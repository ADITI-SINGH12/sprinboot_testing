package com.mockito.testing.bdd.exceptionHandling;

public class DatabaseReadException extends RuntimeException{
    public DatabaseReadException(String message) {
        System.out.println(message);
        //super(message);
    }
}
