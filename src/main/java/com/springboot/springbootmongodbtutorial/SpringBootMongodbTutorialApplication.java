package com.springboot.springbootmongodbtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.springbootmongodbtutorial",
        "com.springboot.springbootmongodbtutorial.controller"})
public class SpringBootMongodbTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbTutorialApplication.class, args);
    }

}
