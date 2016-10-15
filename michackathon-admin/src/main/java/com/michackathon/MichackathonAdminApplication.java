package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * Created by Tomcy John
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class MichackathonAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichackathonAdminApplication.class, args);
    }

}
