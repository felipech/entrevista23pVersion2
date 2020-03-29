package com.entrevistav2.entrevista.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entrevistav2.entrevista.Model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

}
