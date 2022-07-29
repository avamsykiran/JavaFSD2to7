package com.cts.spring.boot.aop.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceSimplImpl implements GreetService {

	@Override
	public String greet(String userName) {
		System.out.println("greet from GreetServiceSimplImpl is being executed...");
		return String.format("%s %s!", "Hello ",userName);
	}

}
