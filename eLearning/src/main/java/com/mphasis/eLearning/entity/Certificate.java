package com.mphasis.eLearning.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class Certificate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  certificateId;
	private LocalDate issueDate;
	@OneToOne
	Employee employee;
	@ManyToOne 
	Course course;
	public int getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(int certificateId, LocalDate issueDate, Employee employee, Course course) {
		super();
		this.certificateId = certificateId;
		this.issueDate = issueDate;
		this.employee = employee;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", issueDate=" + issueDate + ", employee=" + employee
				+ ", course=" + course + "]";
	}
	
	
	
}
