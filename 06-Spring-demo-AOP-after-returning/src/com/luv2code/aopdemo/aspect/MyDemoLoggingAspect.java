package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	// Add a new advice after returning
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "results")
	public void afterRetruningAdvice(JoinPoint theJoinPoint, List<Account> results) {
		// Print out which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("-----> In afterRetruningAdvice() Method signature: " + method);

		// Print out the result
		System.out.println("-----> In afterRetruningAdvice() Result is: " + results);

		// Lets post process the data

		// Convert the Account Name to all Uppercase
		convertAccountNameToUpperCase(results);

	}

	private void convertAccountNameToUpperCase(List<Account> results) {

		System.out.println("\n Conversion Starts...");
		// Loop through Accounts
		for (Account tempAccount : results) {
			// get the uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();

			// update the name in account
			tempAccount.setName(theUpperName);

		}

	}

	// Pointcut declaration. By using the method name we can use it
	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterNoSetter()") // Match all the method in the given package
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		System.out.println("\n====> Calling like Spam by using this  " + "@Before" + getClass());
		
		// Display the method signature
		MethodSignature theMethodSignature=(MethodSignature) theJoinPoint.getSignature();
		System.out.println("The Method Signature Method: "+theMethodSignature);

		// Display the method arguments 
		Object[] obj=theJoinPoint.getArgs();
		for(Object theObj:obj) {
			System.out.println("The Arguments: "+theObj);
			if(theObj instanceof Account) {
				Account theAccount=(Account)theObj;
				System.out.println("THe Value of Acc: Name "+theAccount.getName());
				System.out.println("THe Value of Acc: Level "+theAccount.getLevel());
				
				
			}
			 	
		}
		
		
	}
	
	
	
	 
	
}






