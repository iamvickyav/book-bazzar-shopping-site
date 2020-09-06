package com.iamvickyav.BookBazzar.exception;

import com.iamvickyav.BookBazzar.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ErrorMessage> generateErrorMessage(ConstraintViolationException exception) {
        ErrorMessage errorMessage = new ErrorMessage("INVALID_INPUT", exception.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
