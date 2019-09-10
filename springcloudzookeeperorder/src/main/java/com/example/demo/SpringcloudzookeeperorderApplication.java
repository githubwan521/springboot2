package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SpringcloudzookeeperorderApplication {
	@Autowired
	private RestTemplate restTemplate;

	// springcloud 中使用那些技术实现调用服务接口 feign 或者rest
	@RequestMapping("/orderToMember")
	public String orderToMember() {
		String memberUrl = "http://zkmember/getMember";
		return restTemplate.getForObject(memberUrl, String.class);
	}

/*	@RequestMapping("/discoveryClientMember")
	public List<ServiceInstance> discoveryClientMember() {
		List<ServiceInstance> instances = discoveryClient.getInstances("zk-member");
		for (ServiceInstance serviceInstance : instances) {
			System.out.println("url:" + serviceInstance.getUri());
		}
		return instances;

	}*/

	// 默认rest方式开启 负载均衡功能 如果以app-itmayiedu-member名称进行调用服务接口的时候 必须
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudzookeeperorderApplication.class, args);
	}

}

