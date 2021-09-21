package com.example.demo.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		return ResponseEntity.ok(studentService.getStudent(id));
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student std) throws URISyntaxException {
		studentService.save(std);
		URI uri = new URI("/students");
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.delete(id);
		return "Student deleted successfully";
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
		return ResponseEntity.ok(studentService.update(id, student));
	}
	
}
