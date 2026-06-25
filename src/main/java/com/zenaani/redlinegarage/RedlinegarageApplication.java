package com.zenaani.redlinegarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = "file:.env", ignoreResourceNotFound = true)
public class RedlinegarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedlinegarageApplication.class, args);
	}

}
