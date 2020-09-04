package com.foodFinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(ObjectNotFoundException exc){
        ErrorResponse error= new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(MealsFromDifferentRestaurantsException exc){
        ErrorResponse error= new ErrorResponse();

        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc){
        ErrorResponse error= new ErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
