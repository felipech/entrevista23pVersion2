package com.entrevistav2.entrevista.Service;

import java.util.List;
import java.util.Optional;

import com.entrevistav2.entrevista.Model.Course;
import com.entrevistav2.entrevista.Model.CourseAlone;
import com.entrevistav2.entrevista.Model.Student;
import com.entrevistav2.entrevista.Model.StudentAlone;

public interface ServiceResourse{

	
	public List<Student> listStudents();
	public List<Course> listCourse();
	public Optional<Course> oneCourse(Long id);
	public Optional<Student> oneStudent(Long id);
	
	
	public boolean saveCourseAlone(CourseAlone newCourse);
	public boolean saveStudentAlone(StudentAlone newStudent);
	
	public boolean updateCourseAlone(Long id, CourseAlone updateCourse);
	public boolean updateStudentAlone(Long id, StudentAlone updateStudent);
	
	public boolean deleteCourseAlone(Long id);
	
}
