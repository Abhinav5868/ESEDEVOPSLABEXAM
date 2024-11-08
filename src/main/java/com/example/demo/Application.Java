package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController  // Added since we're creating a web application
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // This method matches the test requirement
    public String getMessage() {
        return "Hello, CI/CD Pipeline!";
    }
}
