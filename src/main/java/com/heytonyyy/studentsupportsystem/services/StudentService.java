package com.heytonyyy.studentsupportsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heytonyyy.studentsupportsystem.models.Student;
import com.heytonyyy.studentsupportsystem.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;
	
//	CREATE STUDENT RECORD
	public Student saveStudent(Student newStudent) {
		return studentRepo.save(newStudent);
	}
	
//	READ STUDENT BY ID
	public Student findStudentByID(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	
}
