package com.ankit;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ankit.controller.EmployeeMgmtController;
import com.ankit.model.Employee;

@SpringBootApplication
public class BootIocProj09ProfileDefaultProfileYmlApplication {

	public static void main(String[] args) {
		//get access IOC container
		ApplicationContext context = SpringApplication.run(BootIocProj09ProfileDefaultProfileYmlApplication.class, args);
		//get access target spring bean class object
		EmployeeMgmtController empController = context.getBean("empCont", EmployeeMgmtController.class);
		//create Scanner class object
		Scanner scn = new Scanner(System.in);
		
		//Select operation
		try {
			System.out.println("************** Select Operation **************");
			System.out.println("Enter the first desg:: ");
			String desg1 = scn.next();
			System.out.println("Enter the second desg :: ");
			String desg2 = scn.next();
			//invoke the b.method
			List<Employee> empList = empController.fetchEmployeeByDesg(desg1, desg2);
			empList.forEach(System.out::println);
		}
		catch (Exception e) {
			System.err.println("Internal problem try again..."+e.getMessage());
		}
		
		//Insert Operation
		try {
			System.out.println("************** Select Operation **************");
			System.out.println("Enter the eno :: ");
			int eno = scn.nextInt();
			System.out.println("Enter the ename :: ");
			String ename = scn.next();
			System.out.println("Enter the desg :: ");
			String desg = scn.next();
			System.err.println("Enter the salary :: ");
			double salary = scn.nextDouble();
			System.out.println("Enter the dno :: ");
			int dno = scn.nextInt();
			//create Employee object
			Employee emp = new Employee();
			emp.setEno(eno);
			emp.setEname(ename);
			emp.setDesg(desg);
			emp.setSalary(salary);
			emp.setDept(dno);
			//invoke the method
			int result = empController.addEmployee(emp);
			System.out.println("No.of records inserted.."+result);
		}
		catch (Exception e) {
			System.err.println("Internal problem try again..."+e.getMessage());
		}
		//close the container
		((ConfigurableApplicationContext) context).close();
	}
}
