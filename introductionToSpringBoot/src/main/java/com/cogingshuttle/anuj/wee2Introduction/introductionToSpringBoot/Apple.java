package com.cogingshuttle.anuj.wee2Introduction.introductionToSpringBoot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component()
public class Apple {
    void eatApple(){
        System.out.println("Eating an apple!");
    }

    @PostConstruct
    void callThisBeforeAppleIsUsed() {
        System.out.println("This method is called before the apple is used.");
    }


    @PreDestroy
    void callThisBeforeAppleIsDestroyed() {
        System.out.println("This method is called before the apple is destroyed.");
    }
}
