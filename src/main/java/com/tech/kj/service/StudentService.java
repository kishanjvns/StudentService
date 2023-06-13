package com.tech.kj.service;

import java.util.List;

import com.tech.kj.dto.StudentDto;
import com.tech.kj.entity.Student;

public interface StudentService {
	 public List<Student> getAllStudents();
	 public Student getStudentById(Long id);
	 public long createStudent( StudentDto Student);
	 public long updateStudent(Long id, Student Student);
	 public long deleteStudent(Long id);
	

}
