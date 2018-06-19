package com.app.learning.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {

    private final int workerCount;

    private final String workerName;
    @Autowired
    private List<Repository> repositories;

    private static final Logger logger = Logger.getLogger(Helper.class.getName());

    public Helper(final int workerCount, final String workerName) {
        this.workerCount = workerCount;
        this.workerName = workerName;
    }

    public void work() {
        logger.log(Level.INFO, "Got repositories");
        repositories.forEach(repo -> logger.log(Level.INFO, "getting data : " + repo.fetchRecords().toString()));
        logger.log(Level.INFO, String.format("Worker %s doing work with %d worker", workerName, workerCount));

    }


}
