package com.springData.SpringDataRest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springData.SpringDataRest.common.exceptions.NoDataFoundException;
import com.springData.SpringDataRest.model.Student;
import com.springData.SpringDataRest.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	IStudentService  studentService;
	
	@RequestMapping("/search/name/{name}")
	public List<Student> findStudentByName(@PathVariable String name){
		List<Student> studentLists=null;
		try{
			studentService.getStudentByName(name);
		}
		catch(NoDataFoundException e){
			System.out.println("No Student found for id");
		}
		return studentLists;
	}
	
	@RequestMapping("/search/id/{studentId}")
	public Student findOneStudent(@PathVariable int studentId){
		Student student = null;
		try {
			student=studentService.getStudentById(studentId);
		}
		catch(NoDataFoundException e){
			System.out.println("No Student found for id");
		}
		return student;
	}
	
	@RequestMapping("/list")
	public List<Student> findAllStudents(){
		return studentService.getAllStudents();
	}
	
	
	@RequestMapping(value="/delete/id/{studentId}" , method=RequestMethod.DELETE)
	public String deleteStudent(@PathVariable int studentId){
		String message;
		try {
			studentService.deleteStudent(studentId);
			message="Student Deleted Successfully";
		} catch (NoDataFoundException e) {
			e.printStackTrace();
			System.out.println("No Student found for id");
			message="No Data Found";
		}
		
		return message;
	}
	
	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public String insertStudent(Student student){
		System.out.println("student:"+student);
		studentService.insertStudent(student);
		String message="Student Inserted Successfully";
		return message;
	}
	
	
	@RequestMapping(value="/edit/id/{studentId}", method=RequestMethod.PUT)
	public String updateStudent(Student student){
		String message;
		try {
			studentService.updateStudent(student);
			message="Student Updated Successfully";
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in Controller");
			message="No Data Found";
		}
		
		return message;
	}
	
}
