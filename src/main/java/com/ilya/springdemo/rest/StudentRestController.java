package com.ilya.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilya.springdemo.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	//define @PostConstuct to load the students .. only once!
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("Ilya", "Mikh"));
		students.add(new Student("Mary", "Smith"));
		students.add(new Student("Valera", "Myky"));
	}
	// define end point for /student - retuen list of student
	
	
	@GetMapping("/students")
	public List<Student> getStudent(){		
		return students;
	}
	
	//define endpoint ffor "/students/{studentId}" - returning student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//just index into the list .. just for now
		
		//chect list size
		if((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - "+studentId);
		}
		
		return students.get(studentId);
	}
		
}
