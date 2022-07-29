package com.cts.spring.boot.aop.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

	public double simpleInterest(double p,double t,double r) {
		System.out.println("Simple interest method is being executed....");
		return (p*t*r)/100;
	}
}
