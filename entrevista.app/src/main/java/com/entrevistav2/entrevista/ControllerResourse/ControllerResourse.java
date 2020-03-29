package com.entrevistav2.entrevista.ControllerResourse;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entrevistav2.entrevista.Model.Course;
import com.entrevistav2.entrevista.Model.CourseAlone;
import com.entrevistav2.entrevista.Model.Student;
import com.entrevistav2.entrevista.Model.StudentAlone;
import com.entrevistav2.entrevista.Service.Impl.ServiceResouseImpl;

@RestController
public class ControllerResourse {

	
	@Autowired
	private ServiceResouseImpl serviceResouseImpl;
	
	@GetMapping("/testMapp")
	public String pruebaGet() {
		return "Test mapping";
	}
	
	@GetMapping("/student/all")
	public List<Student> listStudents(){
		return serviceResouseImpl.listStudents();
	}
	
	@GetMapping("/course/all")
	public List<Course> listCourse(){
		return serviceResouseImpl.listCourse();
	}
	
	@GetMapping("/course/{id}")
	public Optional<Course> oneCourse(@PathVariable Long id){
		return serviceResouseImpl.oneCourse(id);
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> oneStudent(@PathVariable Long id){
		return serviceResouseImpl.oneStudent(id);
	
	}
	
	@Transactional
	@ResponseBody
	@PostMapping("/course")
	public  ResponseEntity<?> newCourse(@RequestBody CourseAlone newCourse) {
		boolean createResponse = false;
		
		createResponse = serviceResouseImpl.saveCourseAlone(newCourse);
		
		if(createResponse) {
			return new ResponseEntity<>(201, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
	}
	
	@Transactional
	@ResponseBody
	@PostMapping("/student")
	public  ResponseEntity<?> newCourse(@RequestBody StudentAlone newStudent) {
		boolean createResponse = false;

		createResponse = serviceResouseImpl.saveStudentAlone(newStudent); 
		
		if(createResponse) {
			return new ResponseEntity<>(201, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
	    
	}
	
	@Transactional
	@PutMapping("/student/{id}/")
	public ResponseEntity<?> updateStudent(@PathVariable long id,@RequestBody StudentAlone updateStudent){
		boolean updateResponse = false;
		
		updateResponse = serviceResouseImpl.updateStudentAlone(id, updateStudent);
		
		if(updateResponse) {
			return new ResponseEntity<>(200, HttpStatus.OK);
		}
		return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
	} 
	
	
	@Transactional
	@PutMapping("/course/{id}/")
	public ResponseEntity<?> updateCourse(@PathVariable long id,@RequestBody CourseAlone updateCourse){
		boolean updateResponse = false;
		
		updateResponse = serviceResouseImpl.updateCourseAlone(id, updateCourse);
		
		if(updateResponse) {
			return new ResponseEntity<>(200, HttpStatus.OK);
		}
		return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
	} 
	
	@Transactional
	@DeleteMapping("/course/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable long id){
		
		boolean updateResponse = false;
		
		updateResponse = serviceResouseImpl.deleteCourseAlone(id);
		
		if(updateResponse) {
			return new ResponseEntity<>(200, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(404, HttpStatus.NOT_FOUND);
	}
	
	
	
}
