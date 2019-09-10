package com.example.erukacluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ErukaClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErukaClusterApplication.class, args);
    }
}
