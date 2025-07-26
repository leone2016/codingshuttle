package com.cogingshuttle.anuj.wee2Introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionToSpringBootApplication implements CommandLineRunner {

	@Autowired
	Apple apple;
	@Autowired
	Apple apple2;

	@Autowired
	DBService dbService;

	public static void main(String[] args) {
		SpringApplication.run(IntroductionToSpringBootApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dbService.getData());

		apple.eatApple();
		apple2.eatApple();

		System.out.println("Are both apples the same instance? " + apple.hashCode() +" :: "+ apple2.hashCode());


	}
}
