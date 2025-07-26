package com.cogingshuttle.anuj.wee2Introduction.introductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "deploy.env", havingValue = "development")
public class DevDB implements DB {

    public String getData() {
        // Simulate fetching data from a development database
        return "Data from the development database";
    }
}
