package com.mphasis.eLearning.entity;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int managerId;
	
	private String managername;
	
	private String managerContact;
	

	@JsonIgnore
	@OneToMany(mappedBy = "managerRef")
	private List<Team> teamList;
	
	@JsonIgnore
	@OneToMany(mappedBy = "managerRef")
	private List<Employee> employeeList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User userRef;
	
	public Manager() {}
	
	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public User getUserRef() {
		return userRef;
	}

	public void setUserRef(User userRef) {
		this.userRef = userRef;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managername=" + managername + ", managerContact=" + managerContact
				+ ", teamList=" + teamList + ", employeeList=" + employeeList + ", userRef=" + userRef + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeList, managerContact, managerId, managername, teamList, userRef);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(employeeList, other.employeeList) && Objects.equals(managerContact, other.managerContact)
				&& managerId == other.managerId && Objects.equals(managername, other.managername)
				&& Objects.equals(teamList, other.teamList) && Objects.equals(userRef, other.userRef);
	};
	
	
	
	

}

