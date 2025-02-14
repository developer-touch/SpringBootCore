//StudentController.java
package com.ankit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.model.Student;
import com.ankit.service.StudentServiceImpl;

@Component("stdCont")
public class StudentController {

	public StudentController() {
		System.out.println("StudentController::0-arg constructor");
	}
	
	//inject StudentServiceImp class object
	@Autowired
	private StudentServiceImpl stdService;
	
	//insert operation
	public int registerStudent(Student student) throws Exception{
		System.out.println("StudentController.registerStudent()");
		int result = 0;
		//invoke b.method
		if(stdService!=null) {
			result = stdService.addStudent(student);
		}
		else {
			throw new IllegalArgumentException("Student service class is null");
		}
		return result;
	}
	
	//search operation by name and course
	public List<Student> findStudentByNameAndCourse(String name,String course) throws Exception{
		System.out.println("StudentController.findStudentByNameAndCourse()");
		return stdService.searchStudentByNameAndCourse(name, course);
	}
	
	//search by id
	public Student findById(Integer id) throws Exception{
		System.out.println("StudentController.findById()");
		Student student = stdService.searchById(id);
		return student;
	}
	
	//update operation
	public int updateStudent(Integer id,String newName,String newCourse,Double newFee,String newGender) throws Exception{
		System.out.println("StudentController.updateStudent()");
		return stdService.edit(id, newName, newCourse, newFee, newGender);
	}
	
	//delete operation
	public int deleteStudent(Integer id) throws Exception{
		System.out.println("StudentController.deleteStudent()");
		return stdService.delete(id);
	}
}
