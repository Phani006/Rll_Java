package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mphasis.eLearning.entity.Course;

public interface ICourseService {
	public Course addCourse(Course course);
	public Course deleteCourse(int courseId);
	public Course updateCourse(Course course);
	public List<Course> getAllCourses();
	public Course getCourseById(int courseId);
	public List<Course> getAllCoursedByCategory(String categoryName);
	public List<Course> getAllCoursedByLevel(String levelName);
	public List<Course> getAllCoursedByInstructor(String instructorName);

}
