package com.employee.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceClientApplication.class, args);
	}

	@Bean
    public RestTemplate getRestTemplate() {
      return new RestTemplate();
    }
}
