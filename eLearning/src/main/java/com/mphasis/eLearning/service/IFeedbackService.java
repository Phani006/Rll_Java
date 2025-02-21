package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Feedback;

public interface IFeedbackService {
	
	public List<Feedback> getAllFeedBacks();
	public Feedback addFeedback(Feedback feedback);
	public Feedback deleteFeedbackById(int feedbackId);
	public Feedback getFeedback(int feeddbackId);

}
