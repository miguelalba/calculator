package com.github.miguelalba.calculator.controller;

public class InvalidOperandException extends RuntimeException {

    InvalidOperandException(int operand) {
        super("Operand must be a positive integer: " + operand);
    }
}
