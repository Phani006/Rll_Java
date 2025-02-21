package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Feedback;
import com.mphasis.eLearning.repository.FeedbackRepository;


@Service
public class FeedbackService implements IFeedbackService {
@Autowired
private FeedbackRepository feedbackRepository;
	@Override
	public List<Feedback> getAllFeedBacks() {
	List<Feedback> feedbackList=feedbackRepository.findAll();
		return feedbackList;
	}

	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback feedback2=feedbackRepository.save(feedback);
		return feedback2;
	}

	@Override
	public Feedback deleteFeedbackById(int feedbackId) {
	Feedback feedback=null;
	if(feedbackRepository.existsById(feedbackId)) {
		feedback=feedbackRepository.findById(feedbackId).get();
		feedbackRepository.deleteById(feedbackId);
	}
		return feedback;
	}

	@Override
	public Feedback getFeedback(int feeddbackId) {
		
		return feedbackRepository.findById(feeddbackId).get();
	}

}
