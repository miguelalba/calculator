package com.github.miguelalba.calculator;

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
}
