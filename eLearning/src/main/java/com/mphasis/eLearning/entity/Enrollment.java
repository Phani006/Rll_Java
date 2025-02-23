package com.mphasis.eLearning.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Enrollment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> CourseRef;
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employeeRef;
	
	private LocalDate date;
	
	public int getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public List<Course> getCourseRef() {
		return CourseRef;
	}
	public void setCourseRef(List<Course> courseRef) {
		CourseRef = courseRef;
	}
	public Employee getEmployeeRef() {
		return employeeRef;
	}
	public void setEmployeeRef(Employee employeeRef) {
		this.employeeRef = employeeRef;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", CourseRef=" + CourseRef + ", employeeRef=" + employeeRef
				+ ", date=" + date + "]";
	}
	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enrollment(int enrollmentId, List<Course> courseRef, Employee employeeRef, LocalDate date) {
		super();
		this.enrollmentId = enrollmentId;
		CourseRef = courseRef;
		this.employeeRef = employeeRef;
		this.date = date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CourseRef, date, employeeRef, enrollmentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollment other = (Enrollment) obj;
		return Objects.equals(CourseRef, other.CourseRef) && Objects.equals(date, other.date)
				&& Objects.equals(employeeRef, other.employeeRef) && enrollmentId == other.enrollmentId;
	}
	
}
