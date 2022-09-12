package com.upc.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BackendtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendtestApplication.class, args);
    }

}
