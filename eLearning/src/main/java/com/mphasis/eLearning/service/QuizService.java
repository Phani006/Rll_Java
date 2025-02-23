package com.mphasis.eLearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Quiz;
import com.mphasis.eLearning.repository.QuizRepository;

@Service
public class QuizService implements IQuizService{
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz getQuizById(int quizId) {
		Quiz quiz=quizRepository.findById(quizId).get();
		return quiz;
	}

}
