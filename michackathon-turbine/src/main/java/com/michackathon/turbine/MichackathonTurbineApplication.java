package com.michackathon.turbine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author Tomcy John
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class MichackathonTurbineApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MichackathonTurbineApplication.class).run(args);
    }
}
