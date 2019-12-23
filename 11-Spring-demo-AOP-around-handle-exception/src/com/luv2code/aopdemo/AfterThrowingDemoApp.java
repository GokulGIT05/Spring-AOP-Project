package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// Read the Spring Config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean
		AccountDAO theAccountDAO = context.getBean(AccountDAO.class);
		
		// Call the new method
		try {
			
			// Add a boolean flag to simulate the exception
			boolean tripWire=true;
			List<Account> theAccount=theAccountDAO.findAccount(tripWire);
			

			// Display the Account
			System.out.println("\nThe Account Details of After Throwing \n\n");
			System.out.println("=========");
			System.out.println("Main Program  Account: "+theAccount);
			System.out.println("\n");
			
		}catch (Exception e) {
			System.out.println("The Exception:  " +e);
		}
		
		


		// close the context
		context.close();

	}

}
