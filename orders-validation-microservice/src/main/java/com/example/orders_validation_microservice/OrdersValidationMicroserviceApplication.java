package com.example.orders_validation_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrdersValidationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersValidationMicroserviceApplication.class, args);
	}

}
