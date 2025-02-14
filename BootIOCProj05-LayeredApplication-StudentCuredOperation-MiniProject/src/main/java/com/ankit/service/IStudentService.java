//IStudentService
package com.ankit.service;

import java.util.List;

import com.ankit.model.Student;

public interface IStudentService {
	public int addStudent(Student student) throws Exception;
	public List<Student> searchStudentByNameAndCourse(String name,String course) throws Exception;
	public int edit(Integer id,String newName,String newCourse,Double newFee,String newGender) throws Exception;
	public int delete(Integer id) throws Exception;
	public Student searchById(Integer id) throws Exception;
}
