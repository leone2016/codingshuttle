package com.cogingshuttle.anuj.wee2Introduction.introductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env", havingValue = "production")
public class ProdDev implements DB {
    public String getData() {
        // Simulate fetching data from a production database
        return "Data from the production database";
    }
}
