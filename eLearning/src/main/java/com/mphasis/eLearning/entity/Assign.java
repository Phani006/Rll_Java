package com.mphasis.eLearning.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Assign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int assignId;

	@ManyToOne(cascade = CascadeType.ALL)
	private Manager managerRef;

	@ManyToOne(cascade = CascadeType.ALL)
	private Team team;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private Course courseRef;

	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employeeRef;
	
	public Assign() {}

	public int getAssignId() {
		return assignId;
	}

	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}

	
	

	public Course getCourseRef() {
		return courseRef;
	}

	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}

	

	public Manager getManagerRef() {
		return managerRef;
	}

	public void setManagerRef(Manager managerRef) {
		this.managerRef = managerRef;
	}

	public Employee getEmployeeRef() {
		return employeeRef;
	}

	public void setEmployeeRef(Employee employeeRef) {
		this.employeeRef = employeeRef;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignId, courseRef, employeeRef, managerRef, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assign other = (Assign) obj;
		return assignId == other.assignId && Objects.equals(courseRef, other.courseRef)
				&& Objects.equals(employeeRef, other.employeeRef) && Objects.equals(managerRef, other.managerRef)
				&& Objects.equals(team, other.team);
	}

	@Override
	public String toString() {
		return "Assign [assignId=" + assignId + ", managerRef=" + managerRef + ", team=" + team + ", courseRef="
				+ courseRef + ", employeeRef=" + employeeRef + "]";
	}

	
	

	

	
	
	



}
