package com.cts.spring.ioc.demo.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.spring.ioc.demo.service.GreetService;

@Component
public class HomeUI {
	
	@Autowired
	private Scanner scan;

	@Autowired
	@Qualifier("greetServiceSimplImpl")
	private GreetService greetService1;

	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService greetService2;

	public void run() {
		System.out.println("Spring IOC Demo Application");
		System.out.println("--------------------------------------------------------------");
		
		System.out.print("User Name? ");
		String userName = scan.nextLine();
		
		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
	}
}
