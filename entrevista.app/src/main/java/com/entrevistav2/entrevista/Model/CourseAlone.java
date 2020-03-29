package com.entrevistav2.entrevista.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "course")
public class CourseAlone {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator( name = "native", strategy = "native")
	private Long id_course;
	private String name;
	private String code;
	
	
	public CourseAlone() {
		
	}


	public CourseAlone(String name, String code) {
		super();
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
	
	
}
