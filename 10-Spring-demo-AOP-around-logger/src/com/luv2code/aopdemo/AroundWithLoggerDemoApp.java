package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger=Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		// Read the Spring Config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean
		TrafficFortuneService theTrafficService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n Main Program:AroundDemoApp ");
		
		myLogger.info("Calling get fortune");
		String data=theTrafficService.setFortune();
		myLogger.info("My Fortune is: "+data);

		// close the context
		context.close();

	}

}
