//Cricketer.java
package com.ankit.sbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cktr")
public final class Cricketer {

	public Cricketer() {
		System.out.println("Cricketer::0-arg constructor");
	}
	
	@Autowired
	@Qualifier("bat")
	private ICricketBat bat;
	
	//b.method
	public String batting(String playerName) {
		System.out.println("Cricketer.batting()");
		//use dependent 
		int runs = bat.scoreRuns();
		return playerName+" has scored "+runs+"runs";
	}
}
