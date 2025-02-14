//MRFBat.java
package com.ankit.sbean;

import java.util.Random;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy(true)
@Component("nikeBat")
public final class NikeBat implements ICricketBat {

	public NikeBat() {
		System.out.println("NikeBat::0-arg constructor)");
	}
	
	@Override
	public int scoreRuns() {
		System.out.println("NikeBat.scoreRuns()");
		int score = new Random().nextInt(200);
		return score;
	}

}
