package com.course.exceptions.four_proyect.controllers;

import com.course.exceptions.four_proyect.Models.Error;
import com.course.exceptions.four_proyect.excepitions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error>divisionByZero(Exception exception){
        Error error = new Error(exception.getMessage(), "division by zero", HttpStatus.INTERNAL_SERVER_ERROR.value(),new Date());
        return ResponseEntity.internalServerError().body(error);
    }
    @ExceptionHandler({NumberFormatException.class})
    public Map<String,Object>numberFormat(Exception exception){
        Map<String,Object>error = new HashMap<>();
        error.put("date",new Date().toString());
        error.put("error","invalid number");
        error.put("message", exception.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }
    @ExceptionHandler({NumberFormatException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    public Map<String,Object>userNotFoundException(Exception exception){
        Map<String,Object>error = new HashMap<>();
        error.put("date",new Date().toString());
        error.put("error"," User not found");
        error.put("message", exception.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<Error>notFoundEx(Exception exception){
        Error error = new Error(exception.getMessage(), "not found", HttpStatus.NOT_FOUND.value(),new Date());
        return ResponseEntity.status(404).body(error);
    }
}
