package com.mphasis.eLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Questions;
import com.mphasis.eLearning.entity.Reports;
import com.mphasis.eLearning.service.QuestionsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/questions")
public class QuestionsController {
	@Autowired
	QuestionsService questionsService;
	@PostMapping("/addquestion")
	public ResponseEntity<?> addQuestion(@RequestBody Questions question){
		Questions question1=questionsService.addQuestion(question);
		return new ResponseEntity<>(question1,HttpStatus.OK);
	}
	@PutMapping("/updatequestion")
	public ResponseEntity<?> updateQuestion(@RequestBody Questions question){
		Questions question1=questionsService.updateQuestion(question);
		return new ResponseEntity<>(question1,HttpStatus.OK);
	}
	@DeleteMapping("/deletequestion/{questionid}")
	public ResponseEntity<?> deleteQuestion(@PathVariable("questionid") int questionId){
		Questions question=questionsService.deleteQuestion(questionId);
		if(question!=null) {
			return new ResponseEntity<>(question,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Question not found with givem question id",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getAllQuestions(@PathVariable("quizId") int quizId){
		List<Questions> qlist=questionsService.Questions(quizId);
			return new ResponseEntity<>(qlist,HttpStatus.OK);
	}
	@PostMapping("/addreports/{stringlist}/{quizid}/{employeeid}/{courseid}")
	public ResponseEntity<?> addReports(@PathVariable("stringlist") List<String> slist,@PathVariable("quizid")int quizid,@PathVariable("employeeid")int empid,@PathVariable("courseid")int courseid){
		Reports reports=questionsService.addoptions(slist, quizid, empid, courseid);
		return new ResponseEntity<>(reports,HttpStatus.OK);
	}
	

}
