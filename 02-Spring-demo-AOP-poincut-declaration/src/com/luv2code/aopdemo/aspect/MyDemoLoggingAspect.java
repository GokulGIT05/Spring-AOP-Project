package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// Pointcut declaration. By using the method name we can use it
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// Generic Form of Pointcut
	@Pointcut("execution(* *..*.*(..))")
	private void commonPointCut() {}
	

	@Before("forDaoPackage()") // Match all the method in the given package
	public void beforeAddAccount() {
		System.out.println("\n====> Calling like Spam by using this  " + "@Before" + getClass());
	}
	
	@Before("commonPointCut()")
	public void performApiAnalytics() {
		System.out.println("Inside performApiAnalytics using generic pointcut");
		
	}

}






