package com.cts.spring.ioc.boot.demo.ui;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.spring.ioc.boot.demo.service.ConversionService;
import com.cts.spring.ioc.boot.demo.service.Counter;
import com.cts.spring.ioc.boot.demo.service.GreetService;

@Component
public class HomeUI {
	
	@Value("${app.title:Spring IOC Demo Application}")
	private String appTitle;
	
	@Autowired
	private Scanner scan;

	@Autowired
	@Qualifier("greetServiceSimplImpl")
	private GreetService greetService1;

	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService greetService2;
	
	@Autowired
	private ConversionService d2r;
	
	@Autowired
	private Counter c1;

	@Autowired
	private Counter c2;
	
	@Autowired
	private Counter c3;
	
	public HomeUI() {
		System.out.println("From Constructor");
		System.out.println(appTitle);
		System.out.println(greetService1);
		System.out.println(c1);
	}
	
	@PostConstruct
	public void startUp() {
		System.out.println("From Post-Construct");
		System.out.println(appTitle);
		System.out.println(greetService1);
		System.out.println(c1);
	}

	public void run() {
		System.out.println(appTitle);
		System.out.println("--------------------------------------------------------------");
		
		System.out.print("User Name? ");
		String userName = scan.nextLine();
		
		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
	
		System.out.print("Dollars? ");
		double dollars = scan.nextDouble();
		double rupees = d2r.convert(dollars);
		double dollars2 = d2r.reverseConvert(rupees);
		
		System.out.println(rupees);
		System.out.println(dollars2);
		
		System.out.println(c1.next());
		System.out.println(c2.next());
		System.out.println(c3.next());
	}
}
