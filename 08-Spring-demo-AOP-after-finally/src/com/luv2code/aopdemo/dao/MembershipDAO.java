package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		System.out.println("Some Stuff to"+getClass());
		return false;
	}
	
	public boolean sleepNice() {
		System.out.println("Inside the sleepNice");
		return true;
	}

}
