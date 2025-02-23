package com.mphasis.eLearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Instructor;
import com.mphasis.eLearning.repository.InstructorRepository;
@Service
public class InstructorService implements IInstructorService{
	 @Autowired
	    private InstructorRepository instructorRepository;


	@Override
	public List<Instructor> getAllInstructors() {
		List<Instructor> instructorList=new ArrayList<>();
		instructorList=instructorRepository.findAll();
		 return instructorList;
	}

	@Override
	public Instructor AddInstructor(Instructor instructor) {
		instructorRepository.save(instructor);
		return instructor;
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) {
		instructorRepository.save(instructor);
		return instructor;
	}

	@Override
	public Instructor deleteInstructor(int instructorId) {
		Instructor instrutor=null;
		if(instructorRepository.existsById(instructorId)) {
			instrutor=instructorRepository.findById(instructorId).get();
			instructorRepository.deleteById(instructorId);
		}
		return instrutor;
	}

	@Override
	public Instructor getInstructorById(int instructorId) {
		Instructor instructor=null;
		if(instructorRepository.existsById(instructorId)) {
			instructor=instructorRepository.findById(instructorId).get();
		}
		return instructor;
	}

	@Override
	public Instructor getInstructorByUserId(int userId) {
		Instructor  instructor=instructorRepository.getInstructorByUserId(userId);
		return instructor;

	}

	

}

