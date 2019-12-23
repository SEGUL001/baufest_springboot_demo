package com.example.demo_baufest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoBaufestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBaufestApplication.class, args);
	}

}
