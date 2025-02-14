package com.ankit.sbean;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerTest implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunnerTest.run()");
		System.out.println("The recieved Cmd line arg values are :: "+Arrays.toString(args));
		for(String arg : args) {
			System.out.println(arg+" ");
		}
		System.out.println("<-------------------------------------->");
	}
}
