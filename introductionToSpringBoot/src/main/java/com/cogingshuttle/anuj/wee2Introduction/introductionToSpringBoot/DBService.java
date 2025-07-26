package com.cogingshuttle.anuj.wee2Introduction.introductionToSpringBoot;

import org.springframework.stereotype.Service;

@Service
public class DBService {
    String getData() {
        // Simulate fetching data from a database
        return "Data from the database";
    }
}
