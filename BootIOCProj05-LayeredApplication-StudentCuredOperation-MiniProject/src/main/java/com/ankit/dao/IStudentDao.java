//IStudentDao.java
package com.ankit.dao;

import java.util.List;

import com.ankit.model.Student;

public interface IStudentDao {
	public int insert(Student student) throws Exception;
	public List<Student> fetchStudent(String name,String course) throws Exception;
	public int update(Integer id,String newName,String newCourse,Double newFee,String newGender) throws Exception;
	public int delete(Integer id) throws Exception;
	public Student fetchById(Integer id) throws Exception;
}
