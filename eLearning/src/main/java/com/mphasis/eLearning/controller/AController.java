package com.mphasis.eLearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Admin;
import com.mphasis.eLearning.service.PracticeAdmin;

@RestController
@RequestMapping("/appi")
public class AController {
	@Autowired
	PracticeAdmin pc;
	@PostMapping("/admin")
	public Admin add(@RequestBody Admin admin) {
		return pc.addAdmi(admin);
	}

}
