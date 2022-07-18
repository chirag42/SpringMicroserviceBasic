package com.customer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(CustomerServiceApplication.class, args);
		System.out.println("Spring Web app started");
		
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
