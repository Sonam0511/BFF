package org.example.BFF;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication


public class BffApplication {

	public static void main(String[] args) {

		SpringApplication.run(BffApplication.class, args);
		System.out.println("Apllication running");
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();


	}
}
