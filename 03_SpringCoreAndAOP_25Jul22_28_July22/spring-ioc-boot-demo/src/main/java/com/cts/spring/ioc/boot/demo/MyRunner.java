package com.cts.spring.ioc.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cts.spring.ioc.boot.demo.ui.HomeUI;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	
	@Override
	public void run(String... args) throws Exception {		
		System.out.println(context.getBean("today"));
		
		HomeUI ui = (HomeUI) context.getBean("homeUI");
		ui.run();
	}

}
