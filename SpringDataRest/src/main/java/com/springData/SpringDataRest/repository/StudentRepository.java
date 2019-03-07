package com.springData.SpringDataRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springData.SpringDataRest.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByName(String name);

}
