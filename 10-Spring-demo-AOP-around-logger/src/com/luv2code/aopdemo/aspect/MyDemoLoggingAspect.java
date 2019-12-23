package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	private static Logger myLogger=Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	//Around Method
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.setFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint 
												theProceedingJoinPoint) throws Throwable {
		
		// Print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("-----> In aroundGetFortune() @Around Method signature: " + method);
		
		//get begin timeStamp
		long begin=System.currentTimeMillis();
		
		//now, lets execute the method
		Object result=theProceedingJoinPoint.proceed();
		
		// get end timestamp
		long end=System.currentTimeMillis();
		
		// Compute the duration
		long theResult=end-begin;
		myLogger.info("The Duration took for the method for completion: "+theResult/1000.0+" Seconds\n");
		
		return result;
		
	}
	
	// After finally
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		// Print out which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("-----> In afterFinallyFindAccountAdvice() Method signature: " + method);
		
		
	}
	
	// After throwing
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
										throwing="theExc")  // theExc matches with method parameter
	public void afterThrowingFindAccounts(JoinPoint theJoinPoint, Throwable theExc) { 
		// Print out which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("-----> In afterThrowingFindAccounts() Method signature: " + method);
		
		// log the Excpetion
		myLogger.info("-----> In afterThrowingFindAccounts() Exception is: " + theExc);

	}
	
	// Add a new advice after returning
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "results")
	public void afterRetruningAdvice(JoinPoint theJoinPoint, List<Account> results) {
		// Print out which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("-----> In afterRetruningAdvice() Method signature: " + method);

		// Print out the result
		myLogger.info("-----> In afterRetruningAdvice() Result is: " + results);

		// Lets post process the data

		// Convert the Account Name to all Uppercase
		convertAccountNameToUpperCase(results);

	}

	private void convertAccountNameToUpperCase(List<Account> results) {

		myLogger.info("\n Conversion Lowercase to Uppercase Starts...");
		// Loop through Accounts
		for (Account tempAccount : results) {
			// get the uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();

			// update the name in account
			tempAccount.setName(theUpperName);

		}
		
		myLogger.info("\n Conversion Lowercase to Uppercase Ends...");

	}

	// Pointcut declaration. By using the method name we can use it
	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterNoSetter()") // Match all the method in
																								// the given package
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		myLogger.info("\n====> Calling like Spam by using this  " + "@Before" + getClass());

		// Display the method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("The Method Signature Method: " + theMethodSignature);

		// Display the method arguments
		Object[] obj = theJoinPoint.getArgs();
		for (Object theObj : obj) {
			myLogger.info("The Arguments: " + theObj);
			if (theObj instanceof Account) {
				Account theAccount = (Account) theObj;
				myLogger.info("THe Value of Acc: Name " + theAccount.getName());
				myLogger.info("THe Value of Acc: Level " + theAccount.getLevel());

			}

		}
		
	}
	
	
	
	 
	
}






