package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// Read the Spring Config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean
		AccountDAO theAccountDAO = context.getBean(AccountDAO.class);
		// CAll Businees method
		Account theacount = new Account();
		theacount.setName("Geetha");
		theacount.setLevel("1");
		theAccountDAO.addAccount(theacount, false, true);
		theAccountDAO.dowork();
		// Calling getter and Setter
		theAccountDAO.setName("Gokul");
		theAccountDAO.setServiceCode("001");
		
		String name=theAccountDAO.getName();
		String code=theAccountDAO.getServiceCode();
		
		
		
		// Get a memership bean from spring container
		MembershipDAO theMember = context.getBean(MembershipDAO.class);
		theMember.addSillyMember();
		theMember.sleepNice();

		// close the context
		context.close();

	}

}
