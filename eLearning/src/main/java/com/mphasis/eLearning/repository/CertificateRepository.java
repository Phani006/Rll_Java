package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Certificates;



@Repository
public interface CertificateRepository extends JpaRepository<Certificates, Integer>{

}
