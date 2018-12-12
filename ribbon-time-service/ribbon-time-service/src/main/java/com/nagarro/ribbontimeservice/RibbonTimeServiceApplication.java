package com.nagarro.ribbontimeservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RibbonTimeServiceApplication {
    @Value("${server.port}")
	private int port ;
	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeServiceApplication.class, args);
	}
	
	@RequestMapping("/")
	public String getTime() {
		return "The current time is "+ new Date().toString() + "(answered by service running on " +port+ ")" ;
	}
}
