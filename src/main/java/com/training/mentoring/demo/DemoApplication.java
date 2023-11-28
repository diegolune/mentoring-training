package com.training.mentoring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.training.mentoring.demo.controllers","com.training.mentoring.demo.services","com.training.mentoring.demo.impl"})
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Starting Mentoring Project");
		SpringApplication.run(DemoApplication.class, args);

	}

}
