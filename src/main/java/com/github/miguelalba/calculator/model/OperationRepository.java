package com.github.miguelalba.calculator.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface OperationRepository extends CrudRepository<Operation, Long> {

//    @Cacheable("additions")
//    public Operation add(int a, int b) {
////        simulatesSlowService();
//        return new Operation("+", a, b, a+b);
//    }
//
//    @Cacheable("substractions")
//    public Operation substract(int a, int b) {
////        simulatesSlowService();
//        return new Operation("-", a, b, a-b);
//    }

//    Optional<Operation> findOperation(String operator, Integer a, Integer b);
    Optional<Operation> findByOperatorAndAAndB(String operator, Integer a, Integer b);

//    Optional<OperationAndResult> findByOperation(Operation operation);

//    private void simulatesSlowService() {
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException err) {
//            throw new IllegalStateException(err);
//        }
//    }
}
