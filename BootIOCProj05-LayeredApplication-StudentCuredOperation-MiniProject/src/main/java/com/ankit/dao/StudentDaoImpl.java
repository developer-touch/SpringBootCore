//StudentDaoImpl.java
package com.ankit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.model.Student;

@Component("stdDao")
public class StudentDaoImpl implements IStudentDao{
	
	//writing SQL Query with static and final variable
	private static final String INSERT_STUDENT = """
			INSERT INTO
			student(student_name,student_course,student_fee,student_gender)
			VALUES (?,?,?,?)
			""";

	private static final String GET_STUDENT = """
			SELECT
			student_id,student_name,student_course,student_fee,student_gender
			FROM student 
			WHERE student_name = ?
			AND student_course = ?
			""";
	
	private static final String UPDATE_STUDENT = """
			UPDATE student
			SET student_name = ?,student_course = ?,student_fee = ?,student_gender = ?
			WHERE
			student_id = ?
			""";
	
	private static final String DELETE_STUDENT = """
			DELETE FROM
			student
			WhERE 
			student_id = ?
			""";
	
	private static final String GET_BY_ID = """
			SELECT 
			student_id,student_name,student_course,student_fee,student_gender
			FROM student
			WHERE
			student_id = ?
			""";
	
	public StudentDaoImpl() {
		System.out.println("StudentDaoImpl::0-arg constructor");
	}
	
	//inject Data Source object to get pooled connection
	@Autowired
	private DataSource ds;
	
	//insert student details
	@Override
	public int insert(Student student) throws Exception {
		System.out.println("StudentDaoImpl.insert()");
		int result = 0;
		
		//established connection b/w DS object
		try(Connection con = ds.getConnection();
				//create PS object having SQL Query
				PreparedStatement ps = con.prepareStatement(INSERT_STUDENT);){
			//set value to QP
			ps.setString(1, student.getName());
			ps.setString(2, student.getCourse());
			ps.setDouble(3, student.getFee());
			ps.setString(4, student.getGender());
			//execute the query
			result = ps.executeUpdate();
		}
		catch (SQLException se) {
			throw se;
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}

	//fetch student details based on name and course
	@Override
	public List<Student> fetchStudent(String name, String course) throws Exception {
		System.out.println("StudentDaoImpl.fetchStudent()");
		//create Student list class object
		ArrayList<Student> stdList = null;
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_STUDENT);){
			//set value to the QP
			ps.setString(1, name);
			ps.setString(2, course);
			//execute the query
			try(ResultSet rs = ps.executeQuery();){
				//assigning object the ArrayList object
				stdList = new ArrayList<Student>();
				//process the result
				while(rs.next()) {
					//create Student class object 
					Student s = new Student();
					s.setId(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setCourse(rs.getString(3));
					s.setFee(rs.getDouble(4));
					s.setGender(rs.getString(5));
					//add to stdList object
					stdList.add(s);
				}
			}
		}
		catch(SQLException se) {
			throw se;
		}
		catch(Exception e) {
			throw e;
		}
		return stdList;
	}

	@Override
	public int update(Integer id, String newName, String newCourse, Double newFee, String newGender) throws Exception {
		System.out.println("StudentDaoImpl.update()");
		
		int result = 0;
		try(Connection con =ds.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_STUDENT);){
			//set value to QP
			ps.setString(1, newName);
			ps.setString(2, newCourse);
			ps.setDouble(3, newFee);
			ps.setString(4, newGender);
			ps.setInt(5, id);
			//execute the query
			result = ps.executeUpdate();
		}
		catch (SQLException se) {
			throw se;
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Integer id) throws Exception {
		System.out.println("StudentDaoImpl.delete()");
		int result = 0;
		//established the connection
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_STUDENT);){
			//set value to QP
			ps.setInt(1, id);
			//execute the query
			result = ps.executeUpdate();
		}
		catch (SQLException se) {
			throw se;
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}

	@Override
	public Student fetchById(Integer id) throws Exception {
		System.out.println("StudentDaoImpl.fetchById()");
		Student student = null;
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_BY_ID);){
			//set value to QP
			ps.setInt(1, id);
			//execute the query
			try(ResultSet rs = ps.executeQuery()){
				//assign object to student 
				student = new Student();
				//process the result
				while(rs.next()) {
					student.setId(rs.getInt(1));
					student.setName(rs.getString(2));
					student.setCourse(rs.getString(3));
					student.setFee(rs.getDouble(4));
					student.setGender(rs.getString(5));
				}
			}
		}
		catch (SQLException se) {
			throw se;
		}
		catch (Exception e) {
			throw e;
		}
		return student;
	}
}
