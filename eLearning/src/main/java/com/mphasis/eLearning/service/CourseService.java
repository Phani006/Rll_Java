package com.mphasis.eLearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Category;
import com.mphasis.eLearning.entity.Course;
import com.mphasis.eLearning.repository.CourseRepository;

@Service
public class CourseService implements ICourseService{
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public Course deleteCourse(int courseId) {
		Course course=null;
		if(courseRepository.existsById(courseId)) {
			course=courseRepository.findById(courseId).get();
			courseRepository.deleteById(courseId);
		}
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courseList=new ArrayList<>();
		courseList=courseRepository.findAll();
		return courseList;
	}

	@Override
	public Course getCourseById(int courseId) {
		Course course=null;
		if(courseRepository.existsById(courseId)) {
			course=courseRepository.findById(courseId).get();
		}
		return course;
	}

	@Override
	public List<Course> getAllCoursedByCategory(String categoryName) {
		List<Course> listOfCourses=courseRepository.getAllCoursedByCategory(categoryName); 
		return listOfCourses;
	}

	@Override
	public List<Course> getAllCoursedByLevel(String levelName) {
		List<Course> listOfCourses=courseRepository.getAllCoursedByLevel(levelName); 
		return listOfCourses;
	}

	@Override
	public List<Course> getAllCoursedByInstructor(String instructorName) {
		List<Course> listOfCourses=courseRepository.getAllCoursedByInstructor(instructorName); 
		return listOfCourses;
	}

}
