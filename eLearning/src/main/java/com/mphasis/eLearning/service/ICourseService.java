package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	public List<Course> getCourseByLevelAndCategory(String CategoryName, String levelName);
	public List<Course> getAssignedEmployeeCourses(int employeeId);
	public double countOfQuizIdByReports( int courseId,int employeeId);
	public Course addCourseWithFiles(Course course,List<MultipartFile> materialFile, List<MultipartFile> videoFiles);

//	public double getProgressByCourseId(int courseId);
//	public int getCountOfmoduleQuizzes(int courseid);
	

}
