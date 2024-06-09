package com.carla.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.carla.api")
@EnableJpaRepositories("com.carla.api.repositories")
public class CompensationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompensationApplication.class, args);
	}

}
