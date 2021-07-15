package com.github.miguelalba.calculator.controller;

public class InvalidOperatorException extends RuntimeException {

    InvalidOperatorException(String operator) {
        super("Operator must be addition(+) or substraction(-): " + operator);
    }
}
