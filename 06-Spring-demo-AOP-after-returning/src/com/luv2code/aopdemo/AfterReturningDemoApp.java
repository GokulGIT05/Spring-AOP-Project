package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// Read the Spring Config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean
		AccountDAO theAccountDAO = context.getBean(AccountDAO.class);
		
		// Call the new method
		List<Account> theAccount=theAccountDAO.findAccount();

		// Display the Account
		System.out.println("\nThe Account Details of After Returning \n\n");
		System.out.println("=========");
		System.out.println("Main Program  Account: "+theAccount);
		System.out.println("\n");

		// close the context
		context.close();

	}

}
