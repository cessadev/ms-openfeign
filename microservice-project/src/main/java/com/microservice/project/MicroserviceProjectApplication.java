package com.microservice.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProjectApplication.class, args);
	}

}
