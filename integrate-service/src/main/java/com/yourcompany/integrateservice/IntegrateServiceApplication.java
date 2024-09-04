package com.yourcompany.integrateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@RestController
public class IntegrateServiceApplication {

    private final WebClient webClient;

    public IntegrateServiceApplication(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build(); // Use base URL if needed
    }

    public static void main(String[] args) {
        SpringApplication.run(IntegrateServiceApplication.class, args);
    }

    @GetMapping("/integrate")
    public String getCombinedMessage() {
        // Fetch response from Hello service
        String hello = webClient.get()
                .uri("http://127.0.0.1:63009/hello")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Fetch response from World service
        String world = webClient.get()
                .uri("http://127.0.0.1:63032/world")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Combine responses
        return hello + " " + world;
    }
}