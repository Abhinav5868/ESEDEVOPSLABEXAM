package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplicationTests {

    @Test
    public void testMessage() {
        Application app = new Application();
        assertEquals("Hello, CI/CD Pipeline!", app.getMessage());
    }

    @Test
    void contextLoads() {
    }
}
