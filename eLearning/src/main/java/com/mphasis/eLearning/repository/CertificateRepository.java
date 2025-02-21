package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer>{

}
