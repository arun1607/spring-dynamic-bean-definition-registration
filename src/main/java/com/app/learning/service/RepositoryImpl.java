package com.app.learning.service;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class RepositoryImpl implements Repository {
    @Override
    public List<String> fetchRecords() {
        return Collections.singletonList("hello");
    }
}
