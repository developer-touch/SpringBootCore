package com.ankit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.ankit.sbean.Cricketer;

@ImportResource("com/ankit/commons/applicationContext.xml")
@SpringBootApplication
public class BootIocProj02StrategyDpApplication {

	public static void main(String[] args) {
		System.out.println("BootIocProj02StrategyDpApplication.main()::started");
		//create IOC Container
		ApplicationContext context = SpringApplication.run(BootIocProj02StrategyDpApplication.class, args);
		//get target spring bean class object reference
		Cricketer cricketer = context.getBean("cktr", Cricketer.class);
		//invoke the b.method
		String scoredRun = cricketer.batting("Pant");
		//print the generated result
		System.out.println(scoredRun);
		//close the container
		((ConfigurableApplicationContext) context).close();
		System.out.println("BootIocProj02StrategyDpApplication.main()::ended");
	}

}
