package com.zenaani.redlinegarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = "file:.env", ignoreResourceNotFound = true)
public class RedlinegarageApplication {

	public static void main(String[] args) {
		System.out.println("SPRING_DATASOURCE_URL = " + System.getenv("SPRING_DATASOURCE_URL"));
		System.out.println("SPRING_DATASOURCE_USERNAME = " + System.getenv("SPRING_DATASOURCE_USERNAME"));
		System.out.println("PORT = " + System.getenv("PORT"));
		SpringApplication.run(RedlinegarageApplication.class, args);
	}

}
