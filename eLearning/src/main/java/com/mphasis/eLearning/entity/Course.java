package com.mphasis.eLearning.entity;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	private String courseName;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employeeRef;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Instructor> instructorRef;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Modules> moduleList;
	 private int courseDuration;
	 
//	 @JsonManagedReference
	 @OneToMany(cascade = CascadeType.ALL)
	 private List<Level> levelList;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 private Category category;
	
	public Course() {}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	

	public List<Employee> getEmployeeRef() {
		return employeeRef;
	}

	public void setEmployeeRef(List<Employee> employeeRef) {
		this.employeeRef = employeeRef;
	}

	public List<Instructor> getInstructorRef() {
		return instructorRef;
	}

	public void setInstructorRef(List<Instructor> instructorRef) {
		this.instructorRef = instructorRef;
	}

	public List<Modules> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Modules> moduleList) {
		this.moduleList = moduleList;
	}
	

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	

	public List<Level> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<Level> levelList) {
		this.levelList = levelList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Course(int courseId, String courseName, List<Employee> employeeRef, List<Instructor> instructorRef,
			List<Modules> moduleList, int courseDuration, List<Level> levelList, Category category) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.employeeRef = employeeRef;
		this.instructorRef = instructorRef;
		this.moduleList = moduleList;
		this.courseDuration = courseDuration;
		this.levelList = levelList;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", employeeRef=" + employeeRef
				+ ", instructorRef=" + instructorRef + ", moduleList=" + moduleList + ", courseDuration="
				+ courseDuration + ", levelList=" + levelList + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, courseDuration, courseId, courseName, employeeRef, instructorRef, levelList,
				moduleList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(category, other.category) && courseDuration == other.courseDuration
				&& courseId == other.courseId && Objects.equals(courseName, other.courseName)
				&& Objects.equals(employeeRef, other.employeeRef) && Objects.equals(instructorRef, other.instructorRef)
				&& Objects.equals(levelList, other.levelList) && Objects.equals(moduleList, other.moduleList);
	}

	
	
	
	
	
	
	
	

}
