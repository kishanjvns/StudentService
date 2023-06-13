package com.tech.kj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.kj.entity.Student;
import com.tech.kj.entity.User;

public interface StudentRepository extends JpaRepository<Student, Long> {

    User findByEmail(String email);
}

