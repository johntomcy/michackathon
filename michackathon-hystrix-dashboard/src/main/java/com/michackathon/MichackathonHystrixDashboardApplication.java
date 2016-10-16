package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Tomcy John
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class MichackathonHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichackathonHystrixDashboardApplication.class, args);
    }

}
