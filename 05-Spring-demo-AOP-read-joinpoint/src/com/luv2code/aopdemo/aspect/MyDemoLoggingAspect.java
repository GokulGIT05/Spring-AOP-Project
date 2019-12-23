package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Acount;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
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
			if(theObj instanceof Acount) {
				Acount theAccount=(Acount)theObj;
				System.out.println("THe Value of Acc: Name "+theAccount.getName());
				System.out.println("THe Value of Acc: Level "+theAccount.getLevel());
				
				
			}
			 	
		}
		
		
	}
	
	
	
	 
	
}






