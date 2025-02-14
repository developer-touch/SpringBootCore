//Student.java
package com.ankit.model;

import lombok.Data;

@Data
public class Student {
	
	public Student(){
		System.out.println("Student::0-arg constructor");
	}
	
	private Integer id;
	private String name;
	private String course;
	private Double fee;
	private String gender;
}	
