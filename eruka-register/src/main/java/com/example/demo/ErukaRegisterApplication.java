package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//开启eurekaServer
public class ErukaRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErukaRegisterApplication.class, args);
	}

}

