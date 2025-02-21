package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Enrollment;

public interface IEnrollmentService {
	public Enrollment addEnrollment(Enrollment enrollment);
	public Enrollment getEnrollment(int enrollMentId);
	public List<Enrollment> getAllEnrollments();
	public Enrollment deleteEnrollment(int enrollmentId);
}
