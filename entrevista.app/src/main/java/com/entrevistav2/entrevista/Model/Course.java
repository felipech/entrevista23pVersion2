package com.entrevistav2.entrevista.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "course")
public class Course implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_course;
	private String name;
	private String code;
	
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "course_has_student",
			joinColumns = {@JoinColumn(name = "course_id_course")},
	        inverseJoinColumns = {@JoinColumn(name = "student_id_student")})
	private Set<Student> student = new HashSet<>();
	
	
	public Course() {
		
	}
	
	public Course(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public Long getId_course() {
		return id_course;
	}

	public void setId_course(Long id_course) {
		this.id_course = id_course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}



	
	

}
