package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Acount;

@Component
public class AccountDAO {
	
	public void addAccount(Acount acc, Boolean vipflag, Boolean vipflag1) {
		System.out.println("Doing MY Db Work from: "+getClass()+"\n");
	}
	
	public boolean dowork() {
		System.out.println("Inside the dowork");
		return true;
	}

}

