package com.mockito.testing.bdd.exceptionHandling;

public class DatabaseWriteException extends RuntimeException {
    public DatabaseWriteException(String s) {
        System.out.println(s);
    }
}
