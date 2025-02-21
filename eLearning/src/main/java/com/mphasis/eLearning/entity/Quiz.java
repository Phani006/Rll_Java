package com.mphasis.eLearning.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizId;
	
	private String quizName;
	

	@OneToMany(cascade = CascadeType.ALL)
	private List<Questions> questionsList;
	
	@JsonIgnore
	@OneToOne(mappedBy = "quizRef")
	private Modules moduleRef;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public List<Questions> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}

	public Modules getModuleRef() {
		return moduleRef;
	}

	public void setModuleRef(Modules moduleRef) {
		this.moduleRef = moduleRef;
	}

	public Quiz(int quizId, String quizName, List<Questions> questionsList, Modules moduleRef) {
		super();
		this.quizId = quizId;
		this.quizName = quizName;
		this.questionsList = questionsList;
		this.moduleRef = moduleRef;
	}

	public Quiz() {
		super();
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizName=" + quizName + ", questionsList=" + questionsList + ", moduleRef="
				+ moduleRef + "]";
	}
	

}
