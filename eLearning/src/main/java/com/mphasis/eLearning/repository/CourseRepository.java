package com.mphasis.eLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	@Query(value="SELECT * " +
            "FROM course c " +
            "Left JOIN category ca ON c.category_category_id = ca.category_id " +
            "WHERE ca.category_name=:categoryName", 
      nativeQuery = true)
	public List<Course> getAllCoursedByCategory(@Param("categoryName") String categoryName);
	
	@Query(value="SELECT * " +
            "FROM course c " +
            "Left JOIN course_level_list ca ON c.course_id = ca.course_course_id " +
            "Left JOIN level l ON ca.level_list_level_id = l.level_id " +
            "WHERE l.level_name=:levelName", 
      nativeQuery = true)
	public List<Course> getAllCoursedByLevel(@Param("levelName") String levelName);

	@Query(value="SELECT * " +
            "FROM course c " +
            "Left JOIN course_instructor_ref ca ON c.course_id = ca.course_course_id " +
            "Left JOIN instructor l ON ca.instructor_ref_instructor_id = l.instructor_id " +
            "WHERE l.instructor_name=:instructorName", 
      nativeQuery = true)
	public List<Course> getAllCoursedByInstructor(@Param("instructorName") String instructorName);
	
	

	
	



}
