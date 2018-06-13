package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

		System.out.println("----------------------------------------------------");

		for (String beanNames : ctx.getBeanDefinitionNames())
			System.out.println(beanNames);

		System.out.println("----------------------------------------------------");

	}
}
