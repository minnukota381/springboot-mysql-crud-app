package com.neptune.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neptune.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}