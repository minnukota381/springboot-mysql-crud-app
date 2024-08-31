package com.neptune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.entity.Student;
import com.neptune.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> students = repo.findAll();
		return students;
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student std = repo.findById(id).get();
		return std;
	}

	@PostMapping("/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}

//	@PutMapping("/students/update/{id}")
//	public Student updateStudent(@PathVariable int id) {
//		Student student=repo.findById(id).get();
//		student.setCgpa(10);
//		student.setEmail("minnukota381@gmail.com");
//		student.setName("Minnu");
//		repo.save(student);
//		return student;
//	}
////	--------------UPDATE IN POSTMAN-------------
//	@PutMapping("/students/update/{id}")
//	public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
//	    Student existingStudent = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
//	    
//	    existingStudent.setName(updatedStudent.getName());
//	    existingStudent.setEmail(updatedStudent.getEmail());
//	    existingStudent.setCgpa(updatedStudent.getCgpa());
//	    
//	    repo.save(existingStudent);
//	    
//	    return existingStudent;
//	}
//	
	@DeleteMapping("/students/delete/{id}")
	public void StudentDelete(@PathVariable int id) {
		Student std = repo.findById(id).get();
		repo.delete(std);
	}
}