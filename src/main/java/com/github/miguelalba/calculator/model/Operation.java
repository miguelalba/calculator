package com.github.miguelalba.calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String operator;
    private int a;
    private int b;
    private int result;

    // Only used by JPA (hence protected)
    protected Operation() {
    }

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

    @Override
    public String toString() {
        return "Operation{" +
                "operator='" + operator + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return a == operation.a &&
                b == operation.b &&
                result == operation.result &&
                Objects.equals(id, operation.id) &&
                Objects.equals(operator, operation.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operator, a, b, result);
    }
}
