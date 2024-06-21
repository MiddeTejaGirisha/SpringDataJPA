package com.example.DTOClassBasedProjections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DtoClassBasedProjectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtoClassBasedProjectionsApplication.class, args);
	}

}
