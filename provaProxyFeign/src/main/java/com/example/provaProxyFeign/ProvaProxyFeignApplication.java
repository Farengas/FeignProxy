package com.example.provaProxyFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

public class ProvaProxyFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaProxyFeignApplication.class, args);
	}

}
