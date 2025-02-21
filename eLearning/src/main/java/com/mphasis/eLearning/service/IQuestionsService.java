package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Questions;
import com.mphasis.eLearning.entity.Reports;

public interface IQuestionsService {
	public Questions  addQuestion(Questions question);
	public Questions deleteQuestion(int questionId);
	public Questions updateQuestion(Questions question);
	public List<Questions> Questions(int quizId);
	public Reports addoptions(List<String> ls,int quizId,int employeeId,int courseId);

}
