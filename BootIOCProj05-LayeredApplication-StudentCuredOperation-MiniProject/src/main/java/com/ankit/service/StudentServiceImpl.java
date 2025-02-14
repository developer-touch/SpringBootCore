package com.ankit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.dao.StudentDaoImpl;
import com.ankit.model.Student;

@Component("stdService")
public class StudentServiceImpl implements IStudentService {

	public StudentServiceImpl() {
		System.out.println("StudentServiceImpl::0-arg constructor");
	}
	
	//inject StudentDao class object 
	@Autowired
	private StudentDaoImpl stdDao;
	
	@Override
	public int addStudent(Student student) throws Exception {
		System.out.println("StudentServiceImpl.addStudent()");
		int result = 0;
		if (stdDao!=null) {
			result = stdDao.insert(student);
		}
		else {
			throw new IllegalArgumentException("StudentDaoImpl is not injected so its null");
		}
		return result;
	}

	//search operation
	@Override
	public List<Student> searchStudentByNameAndCourse(String name, String course) throws Exception {
		System.out.println("StudentServiceImpl.searchStudentByNameAndCourse()");
		name = name.toUpperCase();
		course = course.toUpperCase();
		return stdDao.fetchStudent(name, course);
	}

	@Override
	public int edit(Integer id, String newName, String newCourse, Double newFee, String newGender) throws Exception {
		System.out.println("StudentServiceImpl.edit()");
		return stdDao.update(id, newName, newCourse, newFee, newGender);
	}

	@Override
	public int delete(Integer id) throws Exception {
		System.out.println("StudentServiceImpl.delete()");
		return stdDao.delete(id);
	}

	@Override
	public Student searchById(Integer id) throws Exception {
		System.out.println("StudentServiceImpl.searchById()");
		Student student = stdDao.fetchById(id);
		return student;
	}

}
