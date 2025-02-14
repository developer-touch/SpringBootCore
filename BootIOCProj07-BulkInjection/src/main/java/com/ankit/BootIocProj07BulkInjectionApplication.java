package com.ankit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ankit.sbean.Employee;
import com.ankit.sbean.JobDetails;

@SpringBootApplication
public class BootIocProj07BulkInjectionApplication {

	public static void main(String[] args) {
		//get access IOC container
		ApplicationContext context = SpringApplication.run(BootIocProj07BulkInjectionApplication.class, args);
		//get access target spring bean class object reference
		
		/*JobDetails jd = context.getBean("jd", JobDetails.class);
		System.out.println(jd);*/
		
		Employee emp = context.getBean("emp", Employee.class);
		System.out.println(emp);
		
		//close the container
		((ConfigurableApplicationContext) context).close();
	}

}
