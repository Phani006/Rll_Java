package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Support;
import com.mphasis.eLearning.repository.SupportRepository;

import jakarta.transaction.Transactional;

@Service
public class SupportService implements ISupportService{
	
	@Autowired
	private SupportRepository supportRepository;
	
	@Transactional
	@Override
	public Support addSupport(Support support) {
		supportRepository.save(support);
		return support;
	}

	@Override
	public List<Support> getAllSupports() {
		List<Support> supportList=supportRepository.findAll();
		
		return supportList;
	}

	@Override
	public Support getSupport(int supportId) {
		Support support=supportRepository.findById(supportId).get();
		return support;
	}


}
