package com.github.miguelalba.calculator.model;

import com.github.miguelalba.calculator.model.Operation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class OperationRepository {

//    @Cacheable("operations")
//    public int calculate(Operation operation) {
//        simulatesSlowService();
//        return operation.calculate();
//    }

    @Cacheable("additions")
    public Operation add(int a, int b) {
//        simulatesSlowService();
        return new Operation("+", a, b, a+b);
    }

    @Cacheable("substractions")
    public Operation substract(int a, int b) {
//        simulatesSlowService();
        return new Operation("-", a, b, a-b);
    }

    private void simulatesSlowService() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException err) {
            throw new IllegalStateException(err);
        }
    }
}
