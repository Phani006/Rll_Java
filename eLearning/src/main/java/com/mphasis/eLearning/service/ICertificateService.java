package com.mphasis.eLearning.service;

import com.mphasis.eLearning.entity.Certificates;

public interface ICertificateService {
	

	public byte[] generateCertificate(String userName,String courseName);


	

}
