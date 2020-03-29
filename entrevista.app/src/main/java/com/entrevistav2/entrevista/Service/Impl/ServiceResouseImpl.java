package com.entrevistav2.entrevista.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrevistav2.entrevista.Dao.CourseAloneRepo;
import com.entrevistav2.entrevista.Dao.CourseRepo;
import com.entrevistav2.entrevista.Dao.StudentAloneRepo;
import com.entrevistav2.entrevista.Dao.StudentRepo;
import com.entrevistav2.entrevista.Model.Course;
import com.entrevistav2.entrevista.Model.CourseAlone;
import com.entrevistav2.entrevista.Model.Student;
import com.entrevistav2.entrevista.Model.StudentAlone;
import com.entrevistav2.entrevista.Service.ServiceResourse;

@Service
public class ServiceResouseImpl implements ServiceResourse{

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private StudentAloneRepo studentAloneRepo;
	
	@Autowired
	private CourseAloneRepo courseAlonRepo; 
	
	
	
	public List<Student> listStudents(){
		return studentRepo.findAll();
	}
	
	public List<Course> listCourse(){
		return courseRepo.findAll();
	}
	
	public Optional<Course> oneCourse(Long id){
		return courseRepo.findById(id);
	}
	
	public Optional<Student> oneStudent(Long id){
		return studentRepo.findById(id);
	}
	
	@Override
	public boolean saveCourseAlone(CourseAlone newCourse) {
		
		System.out.println("name --> " + newCourse.getName() + " code--> " + newCourse.getCode());
		boolean validationJson = false;
		
		if(validationJson) {
			courseAlonRepo.save(newCourse);
			return true;
		}
		return true;
		
	}

	@Override
	public boolean saveStudentAlone(StudentAlone student) {
		
		boolean validationJson = false;
		
		validationJson = validationJsonStudent(student);
		
		if(validationJson) {
			studentAloneRepo.save(student);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean updateCourseAlone(Long id, CourseAlone updateCourse) {
		
		try {
			
			boolean validation = false;
			
			validation = validationJsonCourse(updateCourse);
			
			if(validation) {
				courseAlonRepo.findById(id).map(updateCourseAlone ->{
					updateCourseAlone.setName(updateCourse.getName());
					updateCourseAlone.setCode(updateCourse.getCode());
					return courseAlonRepo.save(updateCourseAlone);
				});

				return true;
			}
			
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}

	
	@Override
	public boolean updateStudentAlone(Long id, StudentAlone updateStudent) {
		try {
			
			boolean validation = false;
			
			validation = validationJsonStudent(updateStudent);
			
			if(validation) {
				studentAloneRepo.findById(id).map(updateStudentAlone -> {
				updateStudentAlone.setRut(updateStudent.getRut());
				updateStudentAlone.setName(updateStudent.getName());
				updateStudentAlone.setLastname(updateStudent.getLastname());
				updateStudentAlone.setAge(updateStudent.getAge());
				return studentAloneRepo.save(updateStudentAlone);
				});	

				return true;
			}
			
			return false;
			
		}catch(Exception e) {
			return false;
		}
	


	}
	
	
	public boolean validationJsonStudent(StudentAlone student) {

		if((!(student.getRut() instanceof String)) 
				|| (!(student.getName() instanceof String)) 
				|| (!(student.getLastname() instanceof String))
				|| (!(student.getAge() instanceof Long))) {
					return false;
			}
				
		if(student.getName() == null 
				|| student.getName().equals("") 
				|| student.getLastname() == null 
				|| student.getLastname().equals("")
				|| student.getRut() == null
				|| student.getRut().equals("")
				|| student.getAge() == null) {
			return false;
		}
		
		return true;
	}
	
	public boolean validationJsonCourse(CourseAlone newCourse) {

		if((!(newCourse.getCode() instanceof String)) 
				|| (!(newCourse.getName() instanceof String))) {
			return false;
		}
		
		if(newCourse.getName() == null 
				|| newCourse.getName().equals("") 
				|| newCourse.getCode() == null 
				|| newCourse.getCode().equals("")) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean deleteCourseAlone(Long id) {
		try {
			courseAlonRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
}
