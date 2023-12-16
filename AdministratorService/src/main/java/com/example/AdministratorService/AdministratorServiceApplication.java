package com.example.AdministratorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdministratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministratorServiceApplication.class, args);
	}

}
