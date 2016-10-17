package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Tomcy John
 */
@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableCaching
@EnableCircuitBreaker
public class MichackathonUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichackathonUserApiApplication.class, args);
    }

}
