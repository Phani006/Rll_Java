package com.mphasis.eLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("from User u where u.email=:username and u.password=:password")
	public User Validate(@Param("username") String username,@Param("password") String password);

}
