package com.github.miguelalba.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidOperandAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidOperandException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidOperandHandler(InvalidOperandException err) {
        return err.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(InvalidOperatorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidOperatorHandler(InvalidOperatorException err) {
        return err.getMessage();
    }
}
