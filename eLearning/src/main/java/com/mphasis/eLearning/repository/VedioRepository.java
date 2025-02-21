package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Vedio;

@Repository
public interface VedioRepository extends JpaRepository<Vedio, Integer>{

}
