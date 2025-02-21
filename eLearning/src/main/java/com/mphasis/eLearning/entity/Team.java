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
@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	
	private String teamName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employeeList;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Manager managerRef;
	
	public Team() {}
	
	

	public List<Employee> getEmployeeList() {
		return employeeList;
	}



	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}



	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Manager getManagerRef() {
		return managerRef;
	}

	public void setManagerRef(Manager managerRef) {
		this.managerRef = managerRef;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", employeeList=" + employeeList + ", managerRef="
				+ managerRef + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeList, managerRef, teamId, teamName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(employeeList, other.employeeList) && Objects.equals(managerRef, other.managerRef)
				&& teamId == other.teamId && Objects.equals(teamName, other.teamName);
	};
	
	
	
	

}

