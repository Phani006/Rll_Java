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

import com.mphasis.eLearning.entity.Enrollment;
import com.mphasis.eLearning.service.IEnrollmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
	@Autowired
	private IEnrollmentService enrollmentService;

@GetMapping("/getenrollment")
public ResponseEntity<?> getEnrolemtDeatails( ) {
	List<Enrollment> enrollmentList=enrollmentService.getAllEnrollments();
if(!enrollmentList.isEmpty()) {
	return new ResponseEntity<List<Enrollment>>(enrollmentList,HttpStatus.OK);
	}else {
	return new ResponseEntity<String>("No EnrollmentList Found",HttpStatus.NOT_FOUND);
	}}

	@PostMapping("/postenrollment")
public ResponseEntity<?> addEnroll(@RequestBody Enrollment enrollement){

	Enrollment enrollmentDeatails=enrollmentService.addEnrollment(enrollement);

	if(enrollmentDeatails!=null) {
	return new ResponseEntity<Enrollment>(enrollmentDeatails,HttpStatus.ACCEPTED);
	}else {
	return new ResponseEntity<String>("Unable to enroll ",HttpStatus.BAD_REQUEST);
	}

	}

	@GetMapping("enroll/{enrollmentId}")
	public ResponseEntity<?> getEnrollmentById(@PathVariable int enrollmentId){
Enrollment enrollmentDeatails=enrollmentService.getEnrollment(enrollmentId);

	if(enrollmentDeatails!=null) {
	return new ResponseEntity<Enrollment>(enrollmentDeatails,HttpStatus.FOUND);
	}else {
	return new ResponseEntity<String>("Unable to find the Enrollment deatails",HttpStatus.NOT_FOUND);
	}}

@DeleteMapping("deleteenroll/{enrollmentId}")
public ResponseEntity<?> deleteEnroll(@PathVariable int enrollmentId){
	Enrollment deletedEnroll=enrollmentService.deleteEnrollment(enrollmentId);
	if(deletedEnroll!=null) {
	return new ResponseEntity<Enrollment>(deletedEnroll,HttpStatus.GONE);
	}else {
		return new ResponseEntity<String>("Unable to delete",HttpStatus.BAD_REQUEST);
	}}

}


