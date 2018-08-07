package com.visa.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(RestaurantApiException.class)
  public final ResponseEntity<ErrorDetails> dateNotValidException(RestaurantApiException ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(ex.getInput(), ex.getMessage(), "Please enter a valid date and time");
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
}