package com.mphasis.eLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Support;
import com.mphasis.eLearning.service.ISupportService;

@CrossOrigin("*")
@RestController
@RequestMapping("/support")
public class SupportController {
	
	
	@Autowired
	private ISupportService supportService;
	
	@PostMapping("/addsupport")
	public ResponseEntity<?> addSupport(@RequestBody Support support){
		supportService.addSupport(support);
		return new ResponseEntity<>(support,HttpStatus.OK);
	}
	@GetMapping("/getallsupports")
	public ResponseEntity<?> getAllSupports(){
		List<Support> supportList=supportService.getAllSupports();
		if(supportList!=null) {
			return new ResponseEntity<>(supportList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no supports are found",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getsupport/{supportid}")
	public ResponseEntity<?> getSupport(@PathVariable("supportid") int supportId){
		Support support=supportService.getSupport(supportId);
		if(support!=null) {
			return new ResponseEntity<>(support,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>("no respomse found",HttpStatus.NOT_FOUND);
		}
	}


}
