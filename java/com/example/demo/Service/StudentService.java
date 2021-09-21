package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void save(Student std) {
		studentRepository.save(std);
	}

	public void delete(int id) {
		studentRepository.deleteById(id);
	}

	public Student getStudent(int id) {
		Optional<Student> optStd = studentRepository.findById(id);
		if(optStd.isPresent()) {
			return optStd.get();
		}
		
		return null;
	}

	public String update(int id, Student student) {
		Optional<Student> optStd = studentRepository.findById(id);
		if(optStd.isPresent()) {
			Student std = optStd.get();
			std.setName(student.getName());
			std.setDept(student.getDept());
			studentRepository.save(std);
			
			return "Student updated successfully";
		}
		
		return "No employee exists";
	}

}
