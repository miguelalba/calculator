package com.github.miguelalba.calculator;

class InvalidOperandException extends RuntimeException {

    InvalidOperandException(int operand) {
        super("Operand must be a positive integer: " + operand);
    }
}
