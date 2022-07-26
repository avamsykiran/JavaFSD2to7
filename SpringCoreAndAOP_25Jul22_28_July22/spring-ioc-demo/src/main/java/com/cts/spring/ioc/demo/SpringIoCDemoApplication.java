package com.cts.spring.ioc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.spring.ioc.demo.ui.HomeUI;

public class SpringIoCDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppBeanConfig.class);
		
		System.out.println(context.getBean("today"));
		
		HomeUI ui = (HomeUI) context.getBean("homeUI");
		ui.run();
	}

}
