package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Support;

@Repository
public interface SupportRepository extends JpaRepository<Support, Integer>{

}
