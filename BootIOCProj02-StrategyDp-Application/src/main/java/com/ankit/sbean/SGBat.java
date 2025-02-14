//MRFBat.java
package com.ankit.sbean;

import java.util.Random;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy(true)
@Component("sgBat")
public final class SGBat implements ICricketBat {

	public SGBat() {
		System.out.println("SGBat::0-arg constructor)");
	}
	
	@Override
	public int scoreRuns() {
		System.out.println("SGBat.scoreRuns()");
		int score = new Random().nextInt(200);
		return score;
	}

}
