package com.ankit;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ankit.controller.StudentController;
import com.ankit.model.Student;

@SpringBootApplication
public class BootIocProj05LayeredApplicationStudentCuredOperationMiniProjectApplication {

	public static void main(String[] args) {
		//create spring IOC container
		ApplicationContext context = SpringApplication.run(BootIocProj05LayeredApplicationStudentCuredOperationMiniProjectApplication.class, args);
		//get target spring bean class 
		StudentController stdCont = context.getBean("stdCont", StudentController.class);
		//create Scanner class object 
		Scanner scn = new Scanner(System.in);
		
		//insert operation
		/*try{
			System.out.println(">>>>>>>>>>>>> INSERT OPERATION <<<<<<<<<<<<<<<<");
			System.out.println("Enter student name : ");
			String name = scn.next().toUpperCase();
			System.out.println("Enter student course : ");
			String course = scn.next().toUpperCase();
			System.out.println("Enter course fee :");
			double fee = scn.nextDouble();
			System.out.println("Enter student gender : ");
			String gender = scn.next().toUpperCase();
			
			//create student class object
			Student s = new Student();
			s.setName(name);
			s.setCourse(course);
			s.setFee(fee);
			s.setGender(gender);
			
			//invoke the b.method
			int studentRegistered = stdCont.registerStudent(s);
			
			//print the return message
			System.out.println("no.of record inserted.."+studentRegistered);
		}
		catch (Exception e) {
			System.err.println("Internal problem try again.."+e.getMessage());
		}
		*/
		//find student by name and course
		try {
			System.out.println(">>>>>>>>>>>>> FETCH OPETATION <<<<<<<<<<<<<<<<");
			System.out.println("Enter the student name :: ");
			String name = scn.next();
			System.out.println("Enter the student course :: ");
			String course = scn.next();
			
			//invoke the method
			List<Student> std = stdCont.findStudentByNameAndCourse(name, course);
			//print the result
			std.forEach(System.out::println);
		}
		catch(Exception e) {
			System.err.println("Internal problem try again..."+e.getMessage());
		}
		
		//find by id
		try {
			System.out.println(">>>>>>>>>>>>> FETCH OPETATION <<<<<<<<<<<<<<<<");
			scn.next();
			System.out.println("Enter the student id :: ");
			int id = scn.nextInt();
			
			//invoke the method
			Student student = stdCont.findById(id);
			System.out.println(student);
		}
		catch (Exception e) {
			System.err.println("Internal problem try again..."+e.getMessage());
		}
		//update student 
		try {
			System.out.println(">>>>>>>>>>>>> UPDATE OPETATION <<<<<<<<<<<<<<<<");
			System.out.println("Enter studnet id(whose u want to edit)");
			scn.next(); int id = scn.nextInt();
			System.out.println("Enter student newName : ");	 
			String name = scn.next().toUpperCase();
			System.out.println("Enter student newCourse : ");
			String course = scn.next().toUpperCase(); 
			System.out.println("Enter course newFee :");
			double fee = scn.nextDouble();
			System.out.println("Enter student newGender : ");
			String gender = scn.next().toUpperCase();
			
			//invoke the method
			int result = stdCont.updateStudent(id, name, course, fee, gender);
			
			System.out.println("No.of records updated.."+result);
		}
		catch (Exception e) {
			System.err.println("Internal problem try again..."+e.getMessage());
		}
		
		//delete operation
		try {
			System.out.println(">>>>>>>>>>>>> UPDATE OPETATION <<<<<<<<<<<<<<<<");
			System.out.println("Enter yes to delete opetation :: ");
			scn.next();
			System.out.println("Enter the student id (which one u want to delete) :: ");
			int id = scn.nextInt();
			
			//invoke the method
			int result = stdCont.deleteStudent(id);
			System.out.println("No.of records deleted.."+result);
		}
		catch (Exception e) {
			System.err.println("Internal problem try again..."+e.getMessage());
		}
		//close the container
		((ConfigurableApplicationContext) context).close();
	}

}
