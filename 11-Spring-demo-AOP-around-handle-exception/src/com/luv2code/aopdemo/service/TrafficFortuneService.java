package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String setFortune() {
		// Simulate a delay

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return a fortune
		System.out.println("\nEnd of TrafficFortuneService()\n");
		return "Heavy Traffic";
	}

	public String setFortune(Boolean tripWire) {
		System.out.println("Starting getFortune()");
		
		if(tripWire) {
			throw new RuntimeException("Accident: HighWay CLOSED");
		}
		System.out.println("Ending getFortune()");
		return "Heavy Traffic this Morning";
	}
}
