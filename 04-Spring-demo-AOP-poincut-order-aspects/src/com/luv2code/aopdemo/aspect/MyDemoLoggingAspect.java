package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// Pointcut declaration. By using the method name we can use it
	
	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterNoSetter()") // Match all the method in the given package
	public void beforeAddAccount() {
		System.out.println("\n====> Calling like Spam by using this " + "@Before" + getClass());
	}
	
	
}






