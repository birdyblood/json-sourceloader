package com.birdyblood;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Value("${myKey}")
    private String test;

    public static void main(String[] args) {
        final SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(test);
    }
}
