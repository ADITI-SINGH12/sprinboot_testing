package com.mockito.testing.exception_handling;

public class DatabaseWriteException extends RuntimeException {
    public DatabaseWriteException(String s) {
        System.out.println(s);
    }
}
