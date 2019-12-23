package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

@Aspect
@Controller
@Order(3)
public class LogtoCloudAspect {

//	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterNoSetter()")
	public void logToCloudSync() {
		System.out.println("\n****> Calling like Spam by using this  " + "logToCloudSync()" + getClass());

	}

}
