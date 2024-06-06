package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Student;
import com.rest.service.StudentService;

@RestController
@RequestMapping("/api/")
public class StudentController {
@Autowired	
private StudentService studentservice;	

@PostMapping
public ResponseEntity<Student> createStudent(@RequestBody Student student)
{
	return new ResponseEntity<Student>(studentservice.createStudent(student),HttpStatus.CREATED);
}
	
@GetMapping	("/getAll")
public 	ResponseEntity<List<Student>> getAllStudent()
{
	return new ResponseEntity<List<Student>> (studentservice.getAllStudent(),HttpStatus.OK);
}

@PutMapping	("/deleteStudent/{id}")
public 	ResponseEntity<Student> updateStudent(@PathVariable(value="id")long id,Student student)
{
	return new ResponseEntity<Student> (studentservice.updateStudent(id,student),HttpStatus.OK);
}

@DeleteMapping	("/deleteStudent/{id}")
public 	ResponseEntity<String> deleteStudent(@PathVariable(value="id")long id)
{
	return new ResponseEntity<String> (studentservice.deleteStudent(id),HttpStatus.OK);
}


}
