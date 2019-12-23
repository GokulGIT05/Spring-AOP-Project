package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

@Aspect
@Controller
@Order(1)
public class MyApiAnalyticAspect {

	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterNoSetter()")
	public void performApiAnalytics() {
		System.out.println("\n****> Calling like Spam by using this  " + "performApiAnalytics()" + getClass());

	}

}
