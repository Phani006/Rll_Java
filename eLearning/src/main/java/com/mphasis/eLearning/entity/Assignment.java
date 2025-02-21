package com.mphasis.eLearning.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignmentId;
	
	private String assignmentName;
	
	private List<String> assignmentQuestion;
	
	private List<String> listOfContent;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Course courseRef;
	
	public Assignment() {}

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public List<String> getAssignmentQuestion() {
		return assignmentQuestion;
	}

	public void setAssignmentQuestion(List<String> assignmentQuestion) {
		this.assignmentQuestion = assignmentQuestion;
	}

	public List<String> getListOfContent() {
		return listOfContent;
	}

	public void setListOfContent(List<String> listOfContent) {
		this.listOfContent = listOfContent;
	}

	public Course getCourseRef() {
		return courseRef;
	}

	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}

	public Assignment(int assignmentId, String assignmentName, List<String> assignmentQuestion,
			List<String> listOfContent, Course courseRef) {
		super();
		this.assignmentId = assignmentId;
		this.assignmentName = assignmentName;
		this.assignmentQuestion = assignmentQuestion;
		this.listOfContent = listOfContent;
		this.courseRef = courseRef;
	}

	@Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", assignmentName=" + assignmentName
				+ ", assignmentQuestion=" + assignmentQuestion + ", listOfContent=" + listOfContent + ", courseRef="
				+ courseRef + "]";
	};
	

}

