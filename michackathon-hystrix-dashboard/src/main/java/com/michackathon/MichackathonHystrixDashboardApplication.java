package com.michackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class MichackathonHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MichackathonHystrixDashboardApplication.class, args);
	}
}
