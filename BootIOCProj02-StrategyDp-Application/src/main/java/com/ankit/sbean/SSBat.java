//MRFBat.java
package com.ankit.sbean;

import java.util.Random;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy(true)
@Component("ssBat")
public final class SSBat implements ICricketBat {

	public SSBat() {
		System.out.println("SSBat::0-arg constructor)");
	}
	
	@Override
	public int scoreRuns() {
		System.out.println("SSBat.scoreRuns()");
		int score = new Random().nextInt(200);
		return score;
	}

}
