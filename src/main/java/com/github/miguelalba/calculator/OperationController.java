package com.github.miguelalba.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.OperationNotSupportedException;

@RestController
public class OperationController implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(OperationController.class);

    // Keep application context for closing application on result 42.
    private ApplicationContext context;

    /* Test with curl:
    curl -X POST localhost:8080/operation \
        -H 'Content-type:application/json' \
        -d '{"operator": "+", "a": 2, "b": 2}'
     */
    @PostMapping("/operation")
    Operation newOperation(@RequestBody Operation newOperation) {

        // check a is positive
        if (newOperation.getA() < 0) {
            throw new InvalidOperandException(newOperation.getA());
        }

        // check b is positive
        if (newOperation.getB() < 0) {
            throw new InvalidOperandException(newOperation.getB());
        }

        int result = newOperation.calculate();

        // Quit if result == 42
        if (result == 42) {
            log.info("Result = 42. Closing application.");
            int exitCode = SpringApplication.exit(context, () -> 0);
            System.exit(exitCode);
        }

        log.info(newOperation + " = " + newOperation.calculate());
        return newOperation;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
