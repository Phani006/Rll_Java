package com.mphasis.eLearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.User;
import com.mphasis.eLearning.service.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/validate/{username}/{password}")
	public ResponseEntity<?> validateUser(@PathVariable String username,@PathVariable String password){
		User user=userService.validate(username, password);
		if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(user,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("userbyid/{userId}")
	public ResponseEntity<?> getUserByid(@PathVariable int userId){
		User user=userService.getUserById(userId);
		if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("not found",HttpStatus.BAD_REQUEST);
		}
	}

}
