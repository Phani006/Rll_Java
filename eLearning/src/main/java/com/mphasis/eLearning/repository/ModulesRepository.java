package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Modules;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, Integer>{

}
