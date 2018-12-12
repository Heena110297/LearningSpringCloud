package com.nagarro.ribbontimeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.config.nagarro.RibbonTimeConfigClass;

@SpringBootApplication
@RestController
@RibbonClient(name="time-service" , configuration = RibbonTimeConfigClass.class)
public class RibbonTimeAppApplication {

	@Autowired
	private RestTemplate restTemplate ;
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeAppApplication.class, args);
	}
	
	@RequestMapping("/")
	public String getTime() {
		return restTemplate.getForEntity("http://time-service",String.class).getBody();
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
