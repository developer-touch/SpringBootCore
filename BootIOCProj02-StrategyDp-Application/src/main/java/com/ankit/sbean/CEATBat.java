//MRFBat.java
package com.ankit.sbean;

import java.util.Random;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy(true)
@Component("ceatBat")
public final class CEATBat implements ICricketBat {

	public CEATBat() {
		System.out.println("CEATBat::0-arg constructor)");
	}
	
	@Override
	public int scoreRuns() {
		System.out.println("CEATBat.scoreRuns()");
		int score = new Random().nextInt(200);
		return score;
	}

}
