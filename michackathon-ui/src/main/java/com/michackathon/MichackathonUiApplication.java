package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by Tomcy John
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableZuulProxy
public class MichackathonUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichackathonUiApplication.class, args);
    }

}
