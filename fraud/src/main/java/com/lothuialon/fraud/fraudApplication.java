package com.lothuialon.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lothuialon.clients")
public class fraudApplication {

	public static void main(String[] args) {
		SpringApplication.run(fraudApplication.class, args);
	}

}