package com.cts.spring.boot.aop.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.spring.boot.aop.demo.service.GreetService;

@Component
public class HomeUI implements CommandLineRunner{
	
	@Autowired
	@Qualifier("greetServiceSimplImpl")
	private GreetService greetService1;

	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService greetService2;

	@Override
	public void run(String... args) throws Exception {

		String userName="Vamsy";
		
		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
		
	}
}
