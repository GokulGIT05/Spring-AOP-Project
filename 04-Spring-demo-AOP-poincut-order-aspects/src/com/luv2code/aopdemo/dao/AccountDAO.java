package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Acount;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Acount acc, Boolean vipflag, Boolean vipflag1) {
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

