package com.github.miguelalba.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorApplication {

    private static final Logger log = LoggerFactory.getLogger(CalculatorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    @Bean
    CommandLineRunner doInitialOperations() {
        return args -> {
          Operation firstOperation = new Operation("+", 1, 1);
          Operation secondOperation = new Operation("-", 2, 1);

          log.info(firstOperation.toString() + " = " + firstOperation.calculate());
          log.info(secondOperation.toString() + " = " + secondOperation.calculate());
        };
    }
}