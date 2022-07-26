package com.cts.spring.ioc.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceSimplImpl implements GreetService {

	@Override
	public String greet(String userName) {
		return String.format("%s %s!", "Hello ",userName);
	}

}
