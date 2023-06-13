package com.tech.kj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.kj.dto.StudentDto;
import com.tech.kj.entity.Student;
import com.tech.kj.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public long createStudent(@RequestBody StudentDto user) {
        return studentService.createStudent(user);
    }

    @PutMapping("/{id}")
    public long updateStudent(@PathVariable Long id, @RequestBody Student user) {
    	return studentService.updateStudent(id,user);
    }

    @DeleteMapping("/{id}")
    public long deleteStudent(@PathVariable Long id) {
       return studentService.deleteStudent(id);
    }
}
