package com.education.ztu.spring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException ex) {
        return "error/illegal-argument";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex) {
        return "error/general";
    }
}
