package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.advice;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class )
    public ResponseEntity<ApiError> handleExceptionNotFound(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(apiError , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class )
    public ResponseEntity<ApiError> handleInternalServerError(Exception exception){
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(apiError , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException exception){
        List<String> errorMessage = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
               .toList();

        ApiError apiError = ApiError.builder()
                .message("Input Validation field")
                .subErrors(errorMessage)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(apiError , HttpStatus.BAD_REQUEST);
    }
}
