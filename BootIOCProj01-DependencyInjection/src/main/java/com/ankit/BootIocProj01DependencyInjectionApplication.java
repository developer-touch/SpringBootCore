package com.ankit;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ankit.sbean.WishMessageGenerator;

@SpringBootApplication
public class BootIocProj01DependencyInjectionApplication {

	//LocalDate class
    @Bean("lt")
    LocalTime localTime() {
    	System.out.println("BootIocProj01DependencyInjectionApplication.localTime()");
		return LocalTime.now();
	}
	
	public static void main(String[] args) {
		//create spring IOC container
		ApplicationContext context = SpringApplication.run(BootIocProj01DependencyInjectionApplication.class, args);
		//get target spring bean class object reference
		WishMessageGenerator genertor = context.getBean("wmg", WishMessageGenerator.class);
		//invoke and print the generated result
		System.out.println(genertor.wishMessageGenerator("Ankit"));
		//close the container
		((ConfigurableApplicationContext) context).close();
	}

}
