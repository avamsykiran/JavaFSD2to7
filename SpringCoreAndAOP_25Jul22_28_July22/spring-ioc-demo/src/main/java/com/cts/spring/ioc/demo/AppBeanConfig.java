package com.cts.spring.ioc.demo;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cts.spring.ioc.demo")
public class AppBeanConfig {

	@Bean
	public LocalDate today() {
		return LocalDate.now();
	}

	@Bean
	public Scanner kbin() {
		return new Scanner(System.in);
	}
}