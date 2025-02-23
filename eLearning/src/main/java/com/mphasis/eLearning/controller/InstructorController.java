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

import com.mphasis.eLearning.entity.Instructor;
import com.mphasis.eLearning.service.IInstructorService;


@CrossOrigin("*")
@RestController
@RequestMapping("/instructor")
public class InstructorController {
	@Autowired
	private IInstructorService instructorservice;
	@GetMapping("/getinstructor")
	public ResponseEntity<?> getAllInstructors(){
		List<Instructor> instructorList=instructorservice.getAllInstructors();
		return new ResponseEntity<List<Instructor>>(instructorList,HttpStatus.OK);
		}
	@PostMapping("/addinstructor")
	public ResponseEntity<?> AddInstructor(@RequestBody Instructor instructor){
		Instructor instructoradded=instructorservice.AddInstructor(instructor);
		return new ResponseEntity<Instructor>(instructoradded,HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateinstructor")
	public ResponseEntity<?> updateInstructor(@RequestBody Instructor instructor){
		Instructor instructorupdated=instructorservice.updateInstructor(instructor);
		return new ResponseEntity<Instructor>(instructorupdated,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteinstructor/{instructorId}")
	public ResponseEntity<?> deleteInstructor(@PathVariable("instructorId") int instructorId){
		Instructor instructordeleted=instructorservice.deleteInstructor(instructorId);
		return new ResponseEntity<Instructor>(instructordeleted,HttpStatus.OK);
	}
	@GetMapping("/getinstructorbyid/{instructorid}")
	public ResponseEntity<?> getInstructorById(@PathVariable("instructorid") int instructorId){
		Instructor instructor=instructorservice.getInstructorById(instructorId);
		return new ResponseEntity<Instructor>(instructor,HttpStatus.OK);
	}
	
	@GetMapping("/getinstructorbyiduserId/{userid}")
	public ResponseEntity<?> getInstructorByUserId(@PathVariable("userid") int userId){
		Instructor i=instructorservice.getInstructorByUserId(userId);
		if(i!=null) {
			return new ResponseEntity<Instructor>(i,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("data is not present",HttpStatus.NOT_FOUND);
		}
	}
}
