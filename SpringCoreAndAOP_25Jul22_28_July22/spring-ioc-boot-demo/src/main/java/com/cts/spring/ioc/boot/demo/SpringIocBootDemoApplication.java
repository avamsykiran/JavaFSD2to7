package com.cts.spring.ioc.boot.demo;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringIocBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIocBootDemoApplication.class, args);
	}


	@Bean
	public LocalDate today() {
		return LocalDate.now();
	}

	@Bean
	public Scanner kbin() {
		return new Scanner(System.in);
	}
}
