package com.rest.finalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FinalappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalappApplication.class, args);
	}

}
