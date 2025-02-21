package com.mphasis.eLearning.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	private String employeeName;
	
	private String employeeContact;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Manager managerRef;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Course.class)
	private List<Course> courseList;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Team teamRef;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private User userRef;
	
	public Employee() {}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}

	public Manager getManagerRef() {
		return managerRef;
	}

	public void setManagerRef(Manager managerRef) {
		this.managerRef = managerRef;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Team getTeamRef() {
		return teamRef;
	}

	public void setTeamRef(Team teamRef) {
		this.teamRef = teamRef;
	}

	public User getUserRef() {
		return userRef;
	}

	public void setUserRef(User userRef) {
		this.userRef = userRef;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseList, employeeContact, employeeId, employeeName, managerRef, teamRef, userRef);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(courseList, other.courseList) && Objects.equals(employeeContact, other.employeeContact)
				&& employeeId == other.employeeId && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(managerRef, other.managerRef) && Objects.equals(teamRef, other.teamRef)
				&& Objects.equals(userRef, other.userRef);
	};
	
	
	
	
}