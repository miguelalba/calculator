package com.github.miguelalba.calculator;

public class Operation {

    private String operator;
    private int a;
    private int b;

    // Only used by JPA (hence protected)
    protected Operation() {}

    protected Operation(String operator, int a, int b) {
        this.operator = operator;
        this.a = a;
        this.b = b;
    }

    public String getOperator() {
        return operator;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Operation{" + a + " " + operator + " " + b + "}";
    }

    public int calculate() {
        if (operator.equals("+")) {
            return a+b;
        }
        if (operator.equals("-")) {
            return a-b;
        }
        return 0;
    }
}
