package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Enrollment;
import com.mphasis.eLearning.repository.EnrollmentRepository;
@Service
public class EnrollmentService implements IEnrollmentService {
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public Enrollment addEnrollment(Enrollment enrollment) {

	return enrollmentRepository.save(enrollment);
	}

	@Override
	public Enrollment getEnrollment(int enrollMentId) {
	// TODO Auto-generated method stub
	return enrollmentRepository.findById(enrollMentId).get();
	}

	@Override
	public List<Enrollment> getAllEnrollments() {
	// TODO Auto-generated method stub
	return enrollmentRepository.findAll();
	}

	@Override
	public Enrollment deleteEnrollment(int enrollmentId) {
	Enrollment enrollment=enrollmentRepository.findById(enrollmentId).get();
	if(enrollment!=null) {
	enrollmentRepository.delete(enrollment);
	}
	return enrollment;
	}
}
		 

