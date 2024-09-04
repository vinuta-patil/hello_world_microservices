package com.yourcompany.worldservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
public class WorldServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldServiceApplication.class, args);
    }
}

@RestController
class WorldController {

    @GetMapping("/world")
    public String sayWorld() {
        return "World";
    }
}
