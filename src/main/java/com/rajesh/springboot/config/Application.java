package com.rajesh.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author rajesh
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.rajesh")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
