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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Feedback;
import com.mphasis.eLearning.service.IFeedbackService;

@CrossOrigin("*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	private IFeedbackService iFeedbackService;
	@GetMapping("getAllfeedback")
	public ResponseEntity<?> getAllFeedBacks(){
		List<Feedback> feedbacklist=iFeedbackService.getAllFeedBacks();
		if(!feedbacklist.isEmpty()) {
			return new ResponseEntity<List<Feedback>>(feedbacklist,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("Data feedback is not  there",HttpStatus.NOT_FOUND);
		}
		
	}
	@PostMapping("addFeddBack")
	public ResponseEntity<?> addFeedBack(@RequestBody Feedback feedback){
		Feedback feedback2=iFeedbackService.addFeedback(feedback);
		if(feedback2!=null) {
			return new ResponseEntity<Feedback>(feedback2,HttpStatus.OK);
					}
		else {
			return new ResponseEntity<String>("Data feedback is unable to Add",HttpStatus.NOT_FOUND);
		}
		}
	@DeleteMapping("deleteFeedBack")
	public ResponseEntity<?> deleteFeedbackById(@PathVariable("feedbackId") int feedbackId){
		Feedback feedback2=iFeedbackService.deleteFeedbackById(feedbackId);
		if(feedback2!=null) {
			return new ResponseEntity<Feedback>(feedback2,HttpStatus.OK);
					}
		else {
			return new ResponseEntity<String>("Data feedback is unable to delete or not there",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("getFeedback")
	public ResponseEntity<?> getFeedBack(@PathVariable("feedbackId") int feedbackId){
		Feedback feedback=iFeedbackService.getFeedback(feedbackId);
		if(feedback!=null) {
			return new ResponseEntity<Feedback>(feedback,HttpStatus.OK);
					}
		else {
			return new ResponseEntity<String>("Data feedback is unable to get",HttpStatus.NOT_FOUND);
		}
	}
	}


