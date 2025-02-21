package com.mphasis.eLearning.entity;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	
	private String feedbackName;
	
	private String feedbackContent;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;
	@ManyToOne
	private Course courseRef;
	public Feedback() {}

	public Feedback(int feedbackId, String feedbackName, String feedbackContent, Course courseRef) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackName = feedbackName;
		this.feedbackContent = feedbackContent;
		this.courseRef = courseRef;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackName() {
		return feedbackName;
	}

	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public Course getCourseRef() {
		return courseRef;
	}

	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackName=" + feedbackName + ", feedbackContent="
				+ feedbackContent + ", employee=" + employee + ", courseRef=" + courseRef + "]";
	}

	public Feedback(int feedbackId, String feedbackName, String feedbackContent, Employee employee, Course courseRef) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackName = feedbackName;
		this.feedbackContent = feedbackContent;
		this.employee = employee;
		this.courseRef = courseRef;
	}

	

}
