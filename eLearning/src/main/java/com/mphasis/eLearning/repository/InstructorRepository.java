package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{
	
	@Query(value="select * from instructor where user_ref_user_id=:userid",nativeQuery = true)
	public Instructor getInstructorByUserId(@Param("userid")int userId);

}
