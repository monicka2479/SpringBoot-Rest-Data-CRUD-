package com.springData.SpringDataRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	public Student() {
		
	}

	public Student(int studentId, String name, Double marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name = "STUDENT_ID")
	private int studentId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MARKS")
	private Double marks;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name
				+ ", marks=" + marks + "]";
	}
	
	
	
}
