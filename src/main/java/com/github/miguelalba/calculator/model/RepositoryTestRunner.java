package com.github.miguelalba.calculator.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Test class for testing the repository -> Will be replaced with Application class
@Component
public class RepositoryTestRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RepositoryTestRunner.class);

    private final OperationRepository repository;

    public RepositoryTestRunner(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Initial 2 operations
        logger.info("1+1 -->" + new Operation("+", 1, 1, 2));
        logger.info("2-1 -->" + new Operation("-", 2, 1, 1));

        logger.info(".... Fetching ops from database");
        for (Operation operation : repository.findAll()) {
            logger.info(operation.toString());
        }
    }
}
