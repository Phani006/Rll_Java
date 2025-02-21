package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Instructor;

public interface IInstructorService {
	
	 public List<Instructor> getAllInstructors();
	 public Instructor AddInstructor(Instructor instrutor);
	 public Instructor updateInstructor(Instructor instrutor);
	 public Instructor deleteInstructor(int InstructorID);
	 public Instructor getInstructorById(int InstructorId);

}
