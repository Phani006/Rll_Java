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
public class Reports {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportId;

	private double progress;

	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employeeRef;

	@ManyToOne(cascade = CascadeType.ALL)
	private Course courseRef;
	
	private int quizId;
	
	private int quizScore;
	

	public Reports() {}


	public int getReportId() {
		return reportId;
	}


	public void setReportId(int reportId) {
		this.reportId = reportId;
	}


	public double getProgress() {
		return progress;
	}


	public void setProgress(double progress) {
		this.progress = progress;
	}


	public Employee getEmployeeRef() {
		return employeeRef;
	}


	public void setEmployeeRef(Employee employeeRef) {
		this.employeeRef = employeeRef;
	}


	public Course getCourseRef() {
		return courseRef;
	}


	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}


	public int getQuizId() {
		return quizId;
	}


	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}


	public int getQuizScore() {
		return quizScore;
	}


	public void setQuizScore(int quizScore) {
		this.quizScore = quizScore;
	}


	@Override
	public String toString() {
		return "Reports [reportId=" + reportId + ", progress=" + progress + ", employeeRef=" + employeeRef
				+ ", courseRef=" + courseRef + ", quizId=" + quizId + ", quizScore=" + quizScore + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(courseRef, employeeRef, progress, quizId, quizScore, reportId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reports other = (Reports) obj;
		return Objects.equals(courseRef, other.courseRef) && Objects.equals(employeeRef, other.employeeRef)
				&& Double.doubleToLongBits(progress) == Double.doubleToLongBits(other.progress)
				&& quizId == other.quizId && quizScore == other.quizScore && reportId == other.reportId;
	}

	
	
	

}
