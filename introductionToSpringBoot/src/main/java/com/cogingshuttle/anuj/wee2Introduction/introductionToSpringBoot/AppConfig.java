package com.cogingshuttle.anuj.wee2Introduction.introductionToSpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    /**
     * prototype means a new instance of Apple will be created each time it is requested.
     * singleton means only one instance of Apple will be created and shared.
     * @return
     */
    @Bean
    @Scope("prototype") // or "prototype" for a new instance each time
    public Apple getApple(){
        return new Apple();
    }
}
