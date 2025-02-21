package com.mphasis.eLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Course;
import com.mphasis.eLearning.service.CourseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseService;
	@PostMapping(value ="addcourse",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		  Course course1=courseService.addCourse(course);
		 return new ResponseEntity<>(course1,HttpStatus.OK);
	}
	@GetMapping("/getallcourses")
	public ResponseEntity<?> getAllCourses(){
		List<Course> courseList=courseService.getAllCourses();
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getcoursebyid/{courseid}")
	public ResponseEntity<?> getCourseById(@PathVariable("courseid") int courseId){
		Course course=courseService.getCourseById(courseId);
		if(course!=null) {
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Course doesnot found with given courseId",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/updatecourse")
	public ResponseEntity<?> updateCourse(@RequestBody Course course){
		Course course1=courseService.updateCourse(course);
		return new ResponseEntity<>(course1,HttpStatus.OK);
	}
	@DeleteMapping("/deletecourse/{courseid}")
	public ResponseEntity<?> deleteCourseById(@PathVariable("courseid") int courseid){
		Course course=courseService.deleteCourse(courseid);
		if(course!=null) {
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("course doesnot found with given courseid ",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallcoursesbylevel/{levelName}")
	public ResponseEntity<?> getAllCoursesByLevel(@PathVariable String levelName){
		List<Course> courseList=courseService.getAllCoursedByLevel(levelName);
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallcoursesbycategory/{categoryName}")
	public ResponseEntity<?> getAllCoursesByCategory(@PathVariable String categoryName){
		List<Course> courseList=courseService.getAllCoursedByCategory(categoryName);
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallcoursesbyinstructor/{instructorName}")
	public ResponseEntity<?> getAllCoursesByInstructor(@PathVariable String instructorName){
		List<Course> courseList=courseService.getAllCoursedByInstructor(instructorName);
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}

}
