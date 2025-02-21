package com.mphasis.eLearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Certificate;
import com.mphasis.eLearning.repository.CertificateRepository;

@Service
public class CertificateService implements ICertificateService{
	@Autowired
	CertificateRepository certificateRepository;

	@Override
	public Certificate addCertificate(Certificate certificate) {
		certificateRepository.save(certificate);
		return certificate;
	}

//	@Override
//	public Certificate getCertificate(int employeeId) {
//		if()
//		return null;
//	}

}
