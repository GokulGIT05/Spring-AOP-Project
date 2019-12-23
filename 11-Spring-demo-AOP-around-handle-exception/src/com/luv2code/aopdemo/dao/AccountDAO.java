package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// Adding a newMethod
	public List<Account> findAccount(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("No soup for you");
		}
		List<Account> myAccounts = new ArrayList<>();
		// Create a sample Accounts
		Account theAccount = new Account("Gokul01", "Gold");
		Account theAccount2 = new Account("Gokul02", "Platinum");
		Account theAccount3 = new Account("Gokul03", "Diamond");
		
		System.out.println("\n\n Inside findAccount()\n\n");
		
		// Add them to this list
		myAccounts.add(theAccount);
		myAccounts.add(theAccount2);
		myAccounts.add(theAccount3);

		return myAccounts;
	}
	
	public void addAccount(Account acc, Boolean vipflag, Boolean vipflag1) {
		System.out.println("Doing MY Db Work from: "+getClass()+"\n");
	}
	
	public boolean dowork() {
		System.out.println("Inside the dowork");
		return true;
	}

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	

}

