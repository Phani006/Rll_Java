package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Support;

public interface ISupportService {
	
	public Support addSupport(Support support);
	public List<Support> getAllSupports();
	public Support getSupport(int supportId);


}
