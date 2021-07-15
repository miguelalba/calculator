package com.github.miguelalba.calculator;

import com.github.miguelalba.calculator.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class CalculatorApplication {

    private static final Logger log = LoggerFactory.getLogger(CalculatorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}