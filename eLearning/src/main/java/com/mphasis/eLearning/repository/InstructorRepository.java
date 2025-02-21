package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
