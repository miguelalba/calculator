package com.github.miguelalba.calculator.model;

public class Operation {

    private String operator;
    private int a;
    private int b;
    private int result;

    // Only used by JPA (hence protected)
    protected Operation() {}

    public Operation(String operator, int a, int b, int result) {
        this.operator = operator;
        this.a = a;
        this.b = b;
        this.result = result;
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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operator='" + operator + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", result=" + result +
                '}';
    }

//    public int calculate() {
//        if (operator.equals("+")) {
//            return a+b;
//        }
//        if (operator.equals("-")) {
//            return a-b;
//        }
//        return 0;
//    }
}
