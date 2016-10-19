package com.michackathon.turbine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author Tomcy John
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class MichackathonTurbineApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MichackathonTurbineApplication.class).run(args);
    }
}
