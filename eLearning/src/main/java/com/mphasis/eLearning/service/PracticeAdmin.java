package com.mphasis.eLearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Admin;
import com.mphasis.eLearning.repository.AdminRepository;

@Service
public class PracticeAdmin {
	@Autowired
	public AdminRepository adminRepository;
	
	public Admin addAdmi(Admin a) {
		adminRepository.save(a);
		return a;
	}

}
