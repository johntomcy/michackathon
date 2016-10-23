package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableCircuitBreaker
public class MichackathonFlightApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichackathonFlightApiApplication.class, args);
    }

}
