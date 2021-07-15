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


        // TODO: Initial 2 operations
//        logger.info("1+1 -->" + repository.add(1, 1));
//        logger.info("2-1 -->" + repository.substract(2, 2));

        logger.info(".... Fetching ops");
        for (Operation operation : repository.findAll()) {
            logger.info(operation.toString());
        }
    }
}
