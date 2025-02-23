package com.mphasis.eLearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Quiz;
import com.mphasis.eLearning.service.IQuizService;

@CrossOrigin("*")
@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	private IQuizService quizService;
	
	@GetMapping("quiz/{quizId}")
	public ResponseEntity<?> add(@PathVariable("quizId")int quizId){
	Quiz quiz=quizService.getQuizById(quizId);
	if(quiz!=null) {
		return new ResponseEntity<>(quiz,HttpStatus.OK);
	}else {
		return new ResponseEntity<>("No data",HttpStatus.NOT_FOUND);
	}
	
}
	
	
	

}
