package com.example.school_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.school_Service.Feign")
public class SchoolServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchoolServiceApplication.class, args);
	}
}