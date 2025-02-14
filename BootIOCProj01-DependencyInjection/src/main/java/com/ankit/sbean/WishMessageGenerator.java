package com.ankit.sbean;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-arg constructor");
	}

	@Autowired	// Field Injection
	LocalTime localTime;
	
	//b.method
	public String wishMessageGenerator(String user) {
		//get current hours of day
		int hour = localTime.getHour();
		
		if(hour<12) {
			return "Good morning...."+user;
		}
		else if(hour>=12 && hour<=16) {
			return "Good afternoon...."+user;
		}
		else if(hour>=16 && hour<=20) {
			return "Good afternoon...."+user;
		}
		else {
			return "Good night...."+user;
		}
	}
	
}
