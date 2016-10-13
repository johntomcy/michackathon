package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Tomcy John
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class MichackathonAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichackathonAuthApplication.class, args);
    }

}
