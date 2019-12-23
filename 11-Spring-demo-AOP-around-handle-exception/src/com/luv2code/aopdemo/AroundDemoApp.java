package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// Read the Spring Config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean
		TrafficFortuneService theTrafficService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\n Main Program:AroundDemoApp ");
		
		System.out.println("Calling get fortune");
		String data=theTrafficService.setFortune();
		System.out.println("My Fortune is: "+data);

		// close the context
		context.close();

	}

}
