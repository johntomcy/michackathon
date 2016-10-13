package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by Tomcy John
 */

@SpringBootApplication
@EnableCaching
public class MichackathonCommonTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichackathonCommonTestApplication.class, args);
    }

}
