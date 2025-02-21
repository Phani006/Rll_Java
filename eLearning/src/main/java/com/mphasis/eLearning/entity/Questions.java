package com.mphasis.eLearning.entity;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	
	private String questionName;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;
	
	private String correctAnswer;
	
	private int weightage;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Quiz quizRef;
	
	public Questions() {}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getWeightage() {
		return weightage;
	}

	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}

	public Quiz getQuizRef() {
		return quizRef;
	}

	public void setQuizRef(Quiz quizRef) {
		this.quizRef = quizRef;
	}

	public Questions(int questionId, String questionName, String option1, String option2, String option3,
			String option4, String correctAnswer, int weightage, Quiz quizRef) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnswer = correctAnswer;
		this.weightage = weightage;
		this.quizRef = quizRef;
	}

	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionName=" + questionName + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctAnswer="
				+ correctAnswer + ", weightage=" + weightage + ", quizRef=" + quizRef + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(correctAnswer, option1, option2, option3, option4, questionId, questionName, quizRef,
				weightage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questions other = (Questions) obj;
		return Objects.equals(correctAnswer, other.correctAnswer) && Objects.equals(option1, other.option1)
				&& Objects.equals(option2, other.option2) && Objects.equals(option3, other.option3)
				&& Objects.equals(option4, other.option4) && questionId == other.questionId
				&& Objects.equals(questionName, other.questionName) && Objects.equals(quizRef, other.quizRef)
				&& weightage == other.weightage;
	}

	
	
	
	
	

}

