package com.github.miguelalba.calculator.controller;

import com.github.miguelalba.calculator.model.Operation;
import com.github.miguelalba.calculator.model.OperationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(OperationController.class);

    // Keep application context for closing application on result 42.
    private ApplicationContext context;

    private final OperationRepository repository;

    public OperationController(OperationRepository repository) {
        this.repository = repository;
    }

    /* Test with curl:
    curl localhost:8080/operation/+/2/2
     */
    @Cacheable
    @GetMapping(value = "/operation/{operator}/{a}/{b}", produces = {"application/json"})
    Operation newOperation(
            @PathVariable String operator,
            @PathVariable Integer a,
            @PathVariable Integer b) {

        // check a is positive
        if (a < 0) {
            throw new InvalidOperandException(a);
        }

        // check b is positive
        if (b < 0) {
            throw new InvalidOperandException(b);
        }

        if (!operator.equals("+") && !operator.equals("-")) {
            throw new InvalidOperatorException(operator);
        }

        Operation op = repository.findByOperatorAndAAndB(operator, a, b)
                .orElseGet(() -> {
                    Operation operation = new Operation(operator, a, b, operator.equals("+") ? a+b : a-b);
                    repository.save(operation);
                    return operation;
                });

        // Quit if result == 42
        if (op.getResult() == 42) {
            log.info("Result = 42. Closing application.");
            int exitCode = SpringApplication.exit(context, () -> 0);
            System.exit(exitCode);
        }

        return op;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
