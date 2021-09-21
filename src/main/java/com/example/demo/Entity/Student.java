package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String dept;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hostel_id")
	private StudentHostelDetail stdHostelDetail;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="std_id")
	private Set<StudentDetails> stdDetails;
	
	@ManyToMany
	@JoinTable(name="stdCourse",
				joinColumns = @JoinColumn(name="student_id"),
				inverseJoinColumns = @JoinColumn(name="course_id"))
	private Set<Course> courses;
}
