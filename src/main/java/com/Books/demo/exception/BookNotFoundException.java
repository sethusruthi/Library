package com.Books.demo.exception;
//we write runtimeException so that this class is recognized as exception class

public class BookNotFoundException extends RuntimeException{


    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
