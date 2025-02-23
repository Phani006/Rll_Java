package com.mphasis.eLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Assign;
import com.mphasis.eLearning.service.IAssignService;
import com.mphasis.eLearning.service.IEnrollmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("assign")
public class AssignController {
	@Autowired
	private IAssignService iassignService;
	
	@Autowired
	private IEnrollmentService enrollmentService;

	@PostMapping("addassign")
	public ResponseEntity<?> addAssign(@RequestBody Assign assign){
	Assign assign1=iassignService.assin(assign);
	if(assign!=null) {
	return new ResponseEntity<Assign>(assign1,HttpStatus.OK);
	}
	else {
	return new ResponseEntity<String>("unable to assign",HttpStatus.BAD_REQUEST);
	}
}
	@GetMapping("getassign")
	public ResponseEntity<?> getassign(){
	List<Assign> assign=iassignService.getAll();
	if(!assign.isEmpty()) {
	return new ResponseEntity<List<Assign>>(assign,HttpStatus.OK);
	}else {
	return new ResponseEntity<String>("Assign list is Empty",HttpStatus.NOT_FOUND);
}
	}
	@PostMapping("/add/{employeeid}/{managerid}/{courseid}")
	public ResponseEntity<?> add(@PathVariable("employeeid")int employeeId,@PathVariable("managerid")int managerId,@PathVariable("courseid")int courseId){
	Assign assign1=iassignService.addAssign(employeeId,managerId,courseId);
	return new ResponseEntity<>(assign1,HttpStatus.OK);
}
	@GetMapping("getassignedcourse/{courseId}/{employeeId}")
	public ResponseEntity<?> getAssignedEmployees(@PathVariable("courseId") int courseId,@PathVariable("employeeId") int emloyeeId)
	{
		Assign a=iassignService.getAssignedEmployeeCourse(courseId, emloyeeId);
		if(a!=null) {
		return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
