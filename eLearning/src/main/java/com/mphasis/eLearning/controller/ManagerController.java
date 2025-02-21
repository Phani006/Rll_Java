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

import com.mphasis.eLearning.entity.Manager;
import com.mphasis.eLearning.entity.Team;
import com.mphasis.eLearning.service.IManagerService;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private IManagerService managerService;
	@PostMapping("/addManager")
	public ResponseEntity<?> addManager(@RequestBody Manager manager){
		Manager manager1=managerService.addManager(manager);
		if(manager1!=null) {
			return new ResponseEntity<Manager>(manager1,HttpStatus.OK);
		}
		
		else{
			return new ResponseEntity<String>("Unable to add Manager",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getallmanagers")
	public ResponseEntity<?> getAllManagers(){
		List<Manager> managersList=managerService.getAllManagers();
		if(!managersList.isEmpty()) {
			return new ResponseEntity<List<Manager>>(managersList,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Data is not present in Manager",HttpStatus.NOT_FOUND);
		}
		
	}
	@DeleteMapping("/deletemanager/{managerId}")
	public ResponseEntity<?> deleteManager(@PathVariable("managerId")int managerId){
		Manager manager=managerService.deleteManager(managerId);
		if(manager!=null) {
			return new ResponseEntity<Manager>(manager,HttpStatus.GONE);
		}else {
			return new ResponseEntity<String>("Unable to delete",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getManagerbyid/{managerId}")
	public ResponseEntity<?> getManagerById(@PathVariable("managerId")int managerId){
		Manager manager=managerService.getManagerById(managerId);
		if(manager!=null) {
			return new ResponseEntity<Manager>(manager,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Manager doesnot exist for the given Manager id",HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping("/updatemanager")
	public ResponseEntity<?> updateManager(@RequestBody Manager manager){
		Manager manager1=managerService.updateManager(manager);
		if(manager1!=null) {
			return new ResponseEntity<Manager>(manager1,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("unable to update Manager",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getteams/{userId}")
	public ResponseEntity<?> getTeamsForManager(@PathVariable int userId){
		List<Team> teams=managerService.getTeamByManager(userId);
		if(!teams.isEmpty()) {
			return new ResponseEntity<List<Team>>(teams,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Data is not present in Manager",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("getmanagerid/{userId}")
	public ResponseEntity<?> getManagerId(@PathVariable int userId) {
		Integer managerid=managerService.getManagerId(userId);
		if(managerid!=null) {
			return new ResponseEntity<Integer>(managerid,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
}


