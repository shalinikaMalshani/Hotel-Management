package com.example.RestaurantTest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ServletComponentScan
public class RestaurantTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantTest1Application.class, args);
	}

}
