package com.cts.spring.boot.aop.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

	@Before("execution(* com.cts.spring.boot.aop.demo.service.*.*(..))")
	public void doBefore(JoinPoint jp) {
		System.out.println("Executing before invoking "+jp);
	}
	
	@After("execution(* com.cts.spring.boot.aop.demo.service.*.*(..))")
	public void doAfter(JoinPoint jp) {
		System.out.println("Executing after invoking "+jp);
	}
	
	@Around("execution(* com.cts.spring.boot.aop.demo.service.*.*(..))")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Began executing around  invoking "+jp);
		Object result = jp.proceed();
		System.out.println("Completed executing around  invoking "+jp);
		return result;
	}
}
