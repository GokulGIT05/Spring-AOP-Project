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
	
	// Create a pointcut for getter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void gettermethod() {}
	
	// Create a pointcut for setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void settermethod() {}
	
	// Create a pointcut: include package and exclude getter and setter
	@Pointcut("forDaoPackage() && !(gettermethod() || settermethod() )")
	private void forDAOPackageNoGetterNoSetter() {}
	
	

	@Before("forDAOPackageNoGetterNoSetter()") // Match all the method in the given package
	public void beforeAddAccount() {
		System.out.println("\n====> Calling like Spam by using this  " + "@Before" + getClass());
	}
	
	@Before("forDAOPackageNoGetterNoSetter()")
	public void performApiAnalytics() {
		System.out.println("\n****> Calling like Spam by using this  " + "performApiAnalytics()" + getClass());
		
	}

}






