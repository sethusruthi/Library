package com.Books.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//This controller advice exception will handle multiple exceptions globally
@ControllerAdvice
public class BooksExceptionHandler {
    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException
            (BookNotFoundException bookNotFoundException)
    {
        BookException bookException = new BookException(
                bookNotFoundException.getMessage(),
                bookNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(bookException,HttpStatus.NOT_FOUND);
    }
}
