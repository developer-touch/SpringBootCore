package com.ankit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.ankit.sbean.StudentAddmission;

@SpringBootApplication
@PropertySource("com/ankit/commons/myFile.properties")
public class BootIocProj06ValueAnnotationSpelApplication {

	public static void main(String[] args) {
		//get access IOC container
		ApplicationContext context = SpringApplication.run(BootIocProj06ValueAnnotationSpelApplication.class, args);
		//get access target spring bean class object
		StudentAddmission stdAdd = context.getBean("stdAdd", StudentAddmission.class);
		System.out.println(stdAdd);
		//close the container
		((ConfigurableApplicationContext) context).close();
	}

}
