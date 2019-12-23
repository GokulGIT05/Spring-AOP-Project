package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAOPExpressions {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// Create a pointcut for getter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void gettermethod() {}
	
	// Create a pointcut for setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void settermethod() {}
	
	// Create a pointcut: include package and exclude getter and setter
	@Pointcut("forDaoPackage() && !(gettermethod() || settermethod() )")
	public void forDAOPackageNoGetterNoSetter() {}
	

}
