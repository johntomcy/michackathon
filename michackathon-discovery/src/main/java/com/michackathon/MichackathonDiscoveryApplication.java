package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Tomcy John
 */
@SpringBootApplication
@EnableEurekaServer
public class MichackathonDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichackathonDiscoveryApplication.class, args);
    }

}
