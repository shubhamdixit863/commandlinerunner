package com.commandlinerunner.commandlinerunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CommandlinerunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandlinerunnerApplication.class, args);
    }

// Webclient Builder Bean
    @Bean
    public WebClient.Builder getWebClientBuilder()
    {
        return WebClient.builder();
    }

}
