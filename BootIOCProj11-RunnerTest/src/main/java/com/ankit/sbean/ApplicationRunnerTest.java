package com.ankit.sbean;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerTest implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunnerTest.run()");
		System.out.println("Option Arg values are :: ");
		Set<String> optionNames = args.getOptionNames();
		optionNames.forEach(n->{
			System.out.println("Name :: "+n);
			System.out.println("Values(s) :: "+args.getOptionValues(n));
		});
		
		System.out.println();
		
		System.out.println("Non-Option Arg values are :: ");
		List<String> nonOptionNames = args.getNonOptionArgs();
		nonOptionNames.forEach(n->{
			System.out.println("Name :: "+n);
		});
	}

}
