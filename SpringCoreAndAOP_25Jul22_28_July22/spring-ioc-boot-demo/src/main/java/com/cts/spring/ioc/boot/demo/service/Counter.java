package com.cts.spring.ioc.boot.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Counter {

	@Value("${counter.seed:0}")
	private int count;
	
	public int next() {
		return ++count;
	}
}
