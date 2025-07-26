package com.cogingshuttle.anuj.wee2Introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    DB db;

    String getData() {
        // Simulate fetching data from a database
        return db.getData();
    }
}
