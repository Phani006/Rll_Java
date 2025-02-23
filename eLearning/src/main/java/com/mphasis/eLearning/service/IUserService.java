package com.mphasis.eLearning.service;

import com.mphasis.eLearning.entity.User;

public interface IUserService {
	
	public User validate(String email,String password);
	public User getUserById(int userId);

}
