package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
// 	03. Match only the method in given package 
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // Match all the method in the given package
	public void beforeAddAccount() {
		System.out.println("\n====> Calling like Spam by using this " + "@Before" + getClass());
	}
	
	
	
/*	
//  02. Method param pointcut Expression
//	@Before("execution(* add*(Acount))")  // Throws Exception: Should give fullt qualified exception
//	@Before("execution(* add*(com.luv2code.aopdemo.Acount))") // For parameter type-  Should give fullyQualified name.
//	@Before("execution(* add*(com.luv2code.aopdemo.Acount, ..))") // Match with parameter start with Account type followed by any no. of parameter(..).
	@Before("execution(* add*(..))") // Match method with any no params
	public void beforeAddAccount() {
		System.out.println("\n====> Calling like Spam by using  " + "@Before" + getClass());
	}*/
	
/*	
// Adding Aspect Method
// 	01. Pointcut Expression for method name and return type
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("execution(public void updateAccount())")
//	@Before("execution(public void add*())")  // Wildcard patter (*) --> this will match any method start with 'add'
//	@Before("execution(void add*())") // Modifier is optional - match only with return type void
	@Before("execution(* add*())") // Any Return Type
	public void beforeAddAccount() {
		System.out.println("\n====> Calling like Spam by using this "
									+"@Before"+getClass());
	}*/
	
	
}
