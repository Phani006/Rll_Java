package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Admin;
import com.mphasis.eLearning.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
