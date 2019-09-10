package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SpringcloudzookeepermemberApplication {
	@Value("${server.port}")
	private String serverPort;

	@RequestMapping("/getMember")
	public String getMember(){
		return ("member 服务正在被运行在port = "+serverPort);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudzookeepermemberApplication.class, args);
	}
}

