package com.springData.SpringDataRest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springData.SpringDataRest.common.exceptions.NoDataFoundException;
import com.springData.SpringDataRest.model.Student;
import com.springData.SpringDataRest.repository.StudentRepository;

@Service
@Transactional
public class StudentService implements IStudentService{
	
	@Autowired
	StudentRepository studentRepository;
	List<Student> studentLists ;
	public Student getStudentById(int studentId) throws NoDataFoundException{
		Student student=studentRepository.findOne(studentId);
		if(student==null){
			throw new NoDataFoundException();
		}
		return student;
	}
	
	public List<Student> getStudentByName(String name) throws NoDataFoundException{
		studentLists=studentRepository.findByName(name);
		if(studentLists==null){
			throw new NoDataFoundException();
		}
		return studentLists;
	}
	
	public List<Student> getAllStudents(){
		studentLists=studentRepository.findAll();
		return studentLists;
	}
	
	public void deleteStudent(int studentId) throws NoDataFoundException{
		studentRepository.delete(studentId);
	}
	
	public void insertStudent(Student student){
		studentRepository.save(student);
	}

	@Override
	public void updateStudent(Student student) throws NoDataFoundException {
		Student updatedStudent=studentRepository.findOne(student.getStudentId());
		if(updatedStudent==null){
			throw new NoDataFoundException();
		}
		Student student1=studentRepository.save(student);
		System.out.println("Updated Student:"+student1);
	}
	
}
