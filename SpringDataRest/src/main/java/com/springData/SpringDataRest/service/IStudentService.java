package com.springData.SpringDataRest.service;

import java.util.List;

import com.springData.SpringDataRest.common.exceptions.NoDataFoundException;
import com.springData.SpringDataRest.model.Student;

public interface IStudentService {
	public Student getStudentById(int studentId) throws NoDataFoundException;

	public List<Student> getStudentByName(String name) throws NoDataFoundException;

	public List<Student> getAllStudents();

	public void deleteStudent(int studentId) throws NoDataFoundException;

	public void insertStudent(Student student);

	void updateStudent(Student student) throws NoDataFoundException;
}
